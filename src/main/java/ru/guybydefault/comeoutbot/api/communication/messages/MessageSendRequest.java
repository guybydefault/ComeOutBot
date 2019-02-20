package ru.guybydefault.comeoutbot.api.communication.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.guybydefault.comeoutbot.api.communication.AbstractApiRequest;

public class MessageSendRequest extends AbstractApiRequest {
    /**
     * Id of the recipient
     */
    private Integer userId;

    /**
     * Used to check uniqueness of sent messages to prevent sending duplicate messages
     */
    private Integer randomId;

    /**
     * Destination index (id of user) or  (2000000000 + chat_id) or -(community_id) for community
     */
    private Integer peerId;

    /**
     * Short address of user's page
     */
    private String domain;

    private Integer chatId;
    /**
     * If message is sent to multiple users
     */
    private Integer[] userIds;

    private String message;

    /**
     * Latitude
     */
    private Double lat;

    @JsonProperty("long")
    private Double longitude;

    /**
     * Attachments (media, poll, wall post, etc)
     */
    private String attachment;

    /**
     * Id of the message which is to be replied to
     */
    private Integer replyTo;

    /**
     * Ids of forwarded messages separated by comma
     */
    private String forwardMessages;

    /**
     * Sticker id
     */
    private Integer stickerId;

    /**
     * Group id (for community messages with user key)
     */
    private Integer groupId;

    /**
     * Describes keyboard of the bot
     */
    private String keyboard;


    private Integer payload;

    public MessageSendRequest(String accessToken) {
        super(accessToken);
    }

    public MessageSendRequest(String accessToken, Integer userId, String message) {
        super(accessToken);
        this.userId = userId;
        this.message = message;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRandomId() {
        return randomId;
    }

    void setRandomId(Integer randomId) {
        this.randomId = randomId;
    }

    public Integer getPeerId() {
        return peerId;
    }

    public void setPeerId(Integer peerId) {
        this.peerId = peerId;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public Integer getChatId() {
        return chatId;
    }

    public void setChatId(Integer chatId) {
        this.chatId = chatId;
    }

    public Integer[] getUserIds() {
        return userIds;
    }

    public void setUserIds(Integer[] userIds) {
        this.userIds = userIds;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLong() {
        return longitude;
    }

    public void setLong(Double longitude) {
        this.longitude = longitude;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public Integer getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(Integer replyTo) {
        this.replyTo = replyTo;
    }

    public String getForwardMessages() {
        return forwardMessages;
    }

    public void setForwardMessages(String forwardMessages) {
        this.forwardMessages = forwardMessages;
    }

    public Integer getStickerId() {
        return stickerId;
    }

    public void setStickerId(Integer stickerId) {
        this.stickerId = stickerId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }

    public Integer getPayload() {
        return payload;
    }

    public void setPayload(Integer payload) {
        this.payload = payload;
    }
}
