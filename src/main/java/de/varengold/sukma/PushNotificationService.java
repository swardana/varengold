package de.varengold.sukma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PushNotificationService {

    private static final String TXN_STATUS_FAIL = "FAIL";

    public Response execute(Request request) {
        NotificationVO payload = new NotificationVO();
        /**
         * Map the {@code request} into {@code payload}.
         */
        Response response = new Response();
        /**
         * Populate {@code response} header metadata
         * assumed the process is success.
         */
        List<PushEntity> list = null;
        try {
            if (request != null) {
                payload.setMessageType(request.getMessageType());
                if (!request.getPushTokens().isEmpty()) {
                    payload.setDevices(Arrays.asList(request.getPushTokens().split(",")));
                } else if (!request.getTopics().isEmpty()) {
                    payload.setTopics(Arrays.asList(request.getTopics().split(",")));
                } else {
                    payload.setStatus(TXN_STATUS_FAIL);
                }
                try {
                    if(!payload.getStatus().equals(TXN_STATUS_FAIL)) {
                        SendPushNotification.push(payload);
                        FcmRes fcmRes = payload.getResults();
                        List<FcmResItem> resResult = fcmRes != null ? fcmRes.getResults() : null;
                        if(resResult != null && !resResult.isEmpty()) {
                            list = new ArrayList<>();
                            response.setResults(list);
                            for (FcmResItem item : resResult) {
                                PushEntity entity = new PushEntity();
                                list.add(entity);
                                if (item.getErrorCode() != null && !item.getErrorCode().isEmpty()) {
                                    entity.setPushMessageId(item.getMessageId());
                                } else {
                                    entity.setErrorCode(item.getErrorCode());
                                }
                            }
                        }
                    }
                } catch(RuntimeException ex) {
                    payload.setStatus(TXN_STATUS_FAIL);
                    /**
                     * Update the {@code response} header metadata
                     * to change the status into error
                     */
                }
            }
        } catch(Exception ex) {
            System.out.println("log and ignored");
        } finally {
            if (response.getResults() != null && !response.getResults().isEmpty()) {
                PushNotificationTransService service = new PushNotificationTransService();
                for(PushEntity entity : response.getResults()) {
                    service.createPushNotificationDetails(payload, entity);
                }
            }
        }
        return response;
    }


}
