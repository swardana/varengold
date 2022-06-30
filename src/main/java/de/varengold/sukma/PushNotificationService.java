package de.varengold.sukma;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author laila
 */
public class PushNotificationService {

    private static final String TXN_STATUS_FAIL = "FAIL";

    public Response execute(Request request) {
        NotificationVO payload = new NotificationVO();
        Response response = new Response();
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
                }
            }
        } catch(Exception ex) {
            System.out.println("log and ignored");
        } finally {
            if (response.getResults() != null && !response.getResults().isEmpty()) {
                for(PushEntity entity : response.getResults()) {
                    System.out.println("store into database");
                }
            }
        }
        return response;
    }


}
