package ru.guybydefault.comeoutbot.api.object;

import javax.validation.constraints.Min;

public class Message {
    /**
     * Message identifier
     */
    private Integer id;

    /**
     * Time sent in unixtime
     */
    private Integer date;

    /**
     * Destination id
     */
    private Integer peerId;

    /**
     * Sender id
     */
    @Min(0)
    private Integer fromId;

    /**
     * Body of the message
     */
    private String text;

    /**
     * Identifier used when sending the message
     * Is returned only for sent messages
     */
    private Integer randomId;

    /**
     * Parameter used for working with transitions
     */
    private String ref;

    /**
     * Parameter used for working with transitions
     */
    private String refSource;

    /**
     * Geolocation
     */
    private Object geo;

    /**
     * Media attached to the message
     */
    private Object[] attachments;

    /**
     * True if message is marked as important
     */
    private boolean important;

    /**
     * Service message for bots
     */
    private String payload;

    /**
     * Array of forwarded messages
     */
    private Message[] fwdMessages;


    /**
     * If this message was a reply to another one - that is the one
     */
    private Object replyMessage;


    /**
     * Information about some service actions with the chat
     */
    private Object action;

    /**
     * 0 - received, 1 - sent
     */
    private Integer out;

    /**
     * Conversation message id
     */
    private Integer conversationMessageId;

    /**
     * Is hidden
     */
    private boolean isHidden;

    public Message() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public Integer getPeerId() {
        return peerId;
    }

    public void setPeerId(Integer peerId) {
        this.peerId = peerId;
    }

    public Integer getFromId() {
        return fromId;
    }

    public void setFromId(Integer fromId) {
        this.fromId = fromId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getRandomId() {
        return randomId;
    }

    public void setRandomId(Integer randomId) {
        this.randomId = randomId;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getRefSource() {
        return refSource;
    }

    public void setRefSource(String refSource) {
        this.refSource = refSource;
    }

    public boolean isImportant() {
        return important;
    }

    public void setImportant(boolean important) {
        this.important = important;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public Object getGeo() {
        return geo;
    }

    public void setGeo(Object geo) {
        this.geo = geo;
    }

    public Object[] getAttachments() {
        return attachments;
    }

    public void setAttachments(Object[] attachments) {
        this.attachments = attachments;
    }

    public Message[] getFwdMessages() {
        return fwdMessages;
    }

    public void setFwdMessages(Message[] fwdMessages) {
        this.fwdMessages = fwdMessages;
    }

    public Object getReplyMessage() {
        return replyMessage;
    }

    public void setReplyMessage(Object replyMessage) {
        this.replyMessage = replyMessage;
    }

    public Object getAction() {
        return action;
    }

    public void setAction(Object action) {
        this.action = action;
    }

    public Integer getOut() {
        return out;
    }

    public void setOut(Integer out) {
        this.out = out;
    }

    public Integer getConversationMessageId() {
        return conversationMessageId;
    }

    public void setConversationMessageId(Integer conversationMessageId) {
        this.conversationMessageId = conversationMessageId;
    }

    public boolean getIsHidden() {
        return isHidden;
    }

    public void setIsHidden(boolean hidden) {
        isHidden = hidden;
    }
}
