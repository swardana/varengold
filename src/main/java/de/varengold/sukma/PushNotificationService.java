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
        Response response = new Response();
        NotificationVO payload = new NotificationVO();
        PushNotificationTransService trans = new PushNotificationTransService();
        /**
         * Fill {@code response} header metadata with default value and
         * assume is success.
         */
        if (isTopic(request)) {
            payload.setTopics(Arrays.asList(request.getTopics().split(",")));
            new TopicMessage().send(payload);
        } else if (isDevice(request)) {
            payload.setDevices(Arrays.asList(request.getPushTokens().split(",")));
            new DeviceMessage().send(payload);
        } else {
            // set the {@code response} header metadata as fail.
            payload.setStatus(TXN_STATUS_FAIL);
        }
        List<PushEntity> entities = populateEntities(payload.getResults());
        entities.stream().forEach(e -> trans.createPushNotificationDetails(payload, e));
        response.setResults(entities);
        return response;
    }

    private boolean isTopic(Request request) {
        return request != null && request.getMessageType().equals("TOPIC") &&
            request.getTopics() != null && !request.getTopics().isEmpty();
    }

    private boolean isDevice(Request request) {
        return request != null && request.getMessageType().equals("DEVICE") &&
            request.getPushTokens() != null && !request.getPushTokens().isEmpty();
    }

    private List<PushEntity> populateEntities(FcmRes fcm) {
        List<PushEntity> entities = new ArrayList<>();
        List<FcmResItem> resResult = fcm != null ? fcm.getResults() : null;
        if(resResult != null && !resResult.isEmpty()) {
            for (FcmResItem item : resResult) {
                PushEntity entity = new PushEntity();
                entities.add(entity);
                if (item.getErrorCode() != null && !item.getErrorCode().isEmpty()) {
                    entity.setPushMessageId(item.getMessageId());
                } else {
                    entity.setErrorCode(item.getErrorCode());
                }
            }
        }
        return entities;
    }

}
