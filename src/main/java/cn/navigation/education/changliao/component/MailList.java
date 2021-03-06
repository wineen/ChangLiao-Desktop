package cn.navigation.education.changliao.component;

import cn.navigation.education.changliao.base.BaseLeftContent;
import io.vertx.core.json.JsonObject;
import javafx.scene.layout.BorderPane;

import static cn.navigation.education.changliao.config.Constant.FRIENDS;


/**
 * 通讯录列表
 */

public class MailList extends BaseLeftContent {
    private Notification notification = new Notification();

    public MailList() {
        messageList.getItems().add(notification.getNotificationItem());
    }


    @Override
    public BorderPane getContent() {
        return container;
    }

    @Override
    public void initData(Object o) {
        JsonObject data = (JsonObject) o;
        var friends = data.getJsonArray(FRIENDS);
        friends.forEach(action ->
                messageList.getItems().add(new MailListItem((JsonObject) action).getContent()
                ));
    }

    @Override
    public void updateUi(JsonObject d) {
    }

    public void updateNotification() {
        notification.addNotificationNumber();
    }


}
