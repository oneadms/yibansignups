package com.yiban.test.model.bean;

import java.util.List;

public class TaskDetails {
    /**
     * code : 0
     * msg :
     * data : {"Id":"43406198308a7d716418df16422357e7","Title":"3月20日晚检","Type":1,"State":"uncompleted","ReceiverSendBack":1,"TypeId":"6189674097210f1408e9fa1654bf6dab","AllowSendBackHours":1,"AllowSendBackTimes":1,"PubOrgName":"学生工作处","PubPersonName":"张荣滔","Content":"<p>如实上报<\/p>","AllowTimeout":1,"AttachmentIds":"[]","PubOrgId":"d168e735e8174e474597521717c9fc9f","IsPubPersonShow":1,"CreateTime":1616155603,"StartTime":1616232600,"EndTime":1616248800,"Displayed":1,"TimeState":1,"WFId":"0fdc7d14852072e89644a84c593dfb26","AttachmentList":[],"WorkflowState":0,"InitiateId":"","RetreatReason":"","EvaluationState":0,"EvaluationReason":"","RecordState":0,"CanSendBack":1,"SendBackEndTime":1616252400,"IsLost":0,"Feedback":0,"ChangeReason":""}
     */

    @com.google.gson.annotations.SerializedName("code")
    private Integer code;
    @com.google.gson.annotations.SerializedName("msg")
    private String msg;
    @com.google.gson.annotations.SerializedName("data")
    private DataDTO data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public static class DataDTO {
        /**
         * Id : 43406198308a7d716418df16422357e7
         * Title : 3月20日晚检
         * Type : 1
         * State : uncompleted
         * ReceiverSendBack : 1
         * TypeId : 6189674097210f1408e9fa1654bf6dab
         * AllowSendBackHours : 1
         * AllowSendBackTimes : 1
         * PubOrgName : 学生工作处
         * PubPersonName : 张荣滔
         * Content : <p>如实上报</p>
         * AllowTimeout : 1
         * AttachmentIds : []
         * PubOrgId : d168e735e8174e474597521717c9fc9f
         * IsPubPersonShow : 1
         * CreateTime : 1616155603
         * StartTime : 1616232600
         * EndTime : 1616248800
         * Displayed : 1
         * TimeState : 1
         * WFId : 0fdc7d14852072e89644a84c593dfb26
         * AttachmentList : []
         * WorkflowState : 0
         * InitiateId :
         * RetreatReason :
         * EvaluationState : 0
         * EvaluationReason :
         * RecordState : 0
         * CanSendBack : 1
         * SendBackEndTime : 1616252400
         * IsLost : 0
         * Feedback : 0
         * ChangeReason :
         */

        @com.google.gson.annotations.SerializedName("Id")
        private String Id;
        @com.google.gson.annotations.SerializedName("Title")
        private String Title;
        @com.google.gson.annotations.SerializedName("Type")
        private Integer Type;
        @com.google.gson.annotations.SerializedName("State")
        private String State;
        @com.google.gson.annotations.SerializedName("ReceiverSendBack")
        private Integer ReceiverSendBack;
        @com.google.gson.annotations.SerializedName("TypeId")
        private String TypeId;
        @com.google.gson.annotations.SerializedName("AllowSendBackHours")
        private Integer AllowSendBackHours;
        @com.google.gson.annotations.SerializedName("AllowSendBackTimes")
        private Integer AllowSendBackTimes;
        @com.google.gson.annotations.SerializedName("PubOrgName")
        private String PubOrgName;
        @com.google.gson.annotations.SerializedName("PubPersonName")
        private String PubPersonName;
        @com.google.gson.annotations.SerializedName("Content")
        private String Content;
        @com.google.gson.annotations.SerializedName("AllowTimeout")
        private Integer AllowTimeout;
        @com.google.gson.annotations.SerializedName("AttachmentIds")
        private String AttachmentIds;
        @com.google.gson.annotations.SerializedName("PubOrgId")
        private String PubOrgId;
        @com.google.gson.annotations.SerializedName("IsPubPersonShow")
        private Integer IsPubPersonShow;
        @com.google.gson.annotations.SerializedName("CreateTime")
        private Integer CreateTime;
        @com.google.gson.annotations.SerializedName("StartTime")
        private Integer StartTime;
        @com.google.gson.annotations.SerializedName("EndTime")
        private Integer EndTime;
        @com.google.gson.annotations.SerializedName("Displayed")
        private Integer Displayed;
        @com.google.gson.annotations.SerializedName("TimeState")
        private Integer TimeState;
        @com.google.gson.annotations.SerializedName("WFId")
        private String WFId;
        @com.google.gson.annotations.SerializedName("AttachmentList")
        private List<?> AttachmentList;
        @com.google.gson.annotations.SerializedName("WorkflowState")
        private Integer WorkflowState;
        @com.google.gson.annotations.SerializedName("InitiateId")
        private String InitiateId;
        @com.google.gson.annotations.SerializedName("RetreatReason")
        private String RetreatReason;
        @com.google.gson.annotations.SerializedName("EvaluationState")
        private Integer EvaluationState;
        @com.google.gson.annotations.SerializedName("EvaluationReason")
        private String EvaluationReason;
        @com.google.gson.annotations.SerializedName("RecordState")
        private Integer RecordState;
        @com.google.gson.annotations.SerializedName("CanSendBack")
        private Integer CanSendBack;
        @com.google.gson.annotations.SerializedName("SendBackEndTime")
        private Integer SendBackEndTime;
        @com.google.gson.annotations.SerializedName("IsLost")
        private Integer IsLost;
        @com.google.gson.annotations.SerializedName("Feedback")
        private Integer Feedback;
        @com.google.gson.annotations.SerializedName("ChangeReason")
        private String ChangeReason;

        public String getId() {
            return Id;
        }

        public void setId(String Id) {
            this.Id = Id;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }

        public Integer getType() {
            return Type;
        }

        public void setType(Integer Type) {
            this.Type = Type;
        }

        public String getState() {
            return State;
        }

        public void setState(String State) {
            this.State = State;
        }

        public Integer getReceiverSendBack() {
            return ReceiverSendBack;
        }

        public void setReceiverSendBack(Integer ReceiverSendBack) {
            this.ReceiverSendBack = ReceiverSendBack;
        }

        public String getTypeId() {
            return TypeId;
        }

        public void setTypeId(String TypeId) {
            this.TypeId = TypeId;
        }

        public Integer getAllowSendBackHours() {
            return AllowSendBackHours;
        }

        public void setAllowSendBackHours(Integer AllowSendBackHours) {
            this.AllowSendBackHours = AllowSendBackHours;
        }

        public Integer getAllowSendBackTimes() {
            return AllowSendBackTimes;
        }

        public void setAllowSendBackTimes(Integer AllowSendBackTimes) {
            this.AllowSendBackTimes = AllowSendBackTimes;
        }

        public String getPubOrgName() {
            return PubOrgName;
        }

        public void setPubOrgName(String PubOrgName) {
            this.PubOrgName = PubOrgName;
        }

        public String getPubPersonName() {
            return PubPersonName;
        }

        public void setPubPersonName(String PubPersonName) {
            this.PubPersonName = PubPersonName;
        }

        public String getContent() {
            return Content;
        }

        public void setContent(String Content) {
            this.Content = Content;
        }

        public Integer getAllowTimeout() {
            return AllowTimeout;
        }

        public void setAllowTimeout(Integer AllowTimeout) {
            this.AllowTimeout = AllowTimeout;
        }

        public String getAttachmentIds() {
            return AttachmentIds;
        }

        public void setAttachmentIds(String AttachmentIds) {
            this.AttachmentIds = AttachmentIds;
        }

        public String getPubOrgId() {
            return PubOrgId;
        }

        public void setPubOrgId(String PubOrgId) {
            this.PubOrgId = PubOrgId;
        }

        public Integer getIsPubPersonShow() {
            return IsPubPersonShow;
        }

        public void setIsPubPersonShow(Integer IsPubPersonShow) {
            this.IsPubPersonShow = IsPubPersonShow;
        }

        public Integer getCreateTime() {
            return CreateTime;
        }

        public void setCreateTime(Integer CreateTime) {
            this.CreateTime = CreateTime;
        }

        public Integer getStartTime() {
            return StartTime;
        }

        public void setStartTime(Integer StartTime) {
            this.StartTime = StartTime;
        }

        public Integer getEndTime() {
            return EndTime;
        }

        public void setEndTime(Integer EndTime) {
            this.EndTime = EndTime;
        }

        public Integer getDisplayed() {
            return Displayed;
        }

        public void setDisplayed(Integer Displayed) {
            this.Displayed = Displayed;
        }

        public Integer getTimeState() {
            return TimeState;
        }

        public void setTimeState(Integer TimeState) {
            this.TimeState = TimeState;
        }

        public String getWFId() {
            return WFId;
        }

        public void setWFId(String WFId) {
            this.WFId = WFId;
        }

        public List<?> getAttachmentList() {
            return AttachmentList;
        }

        public void setAttachmentList(List<?> AttachmentList) {
            this.AttachmentList = AttachmentList;
        }

        public Integer getWorkflowState() {
            return WorkflowState;
        }

        public void setWorkflowState(Integer WorkflowState) {
            this.WorkflowState = WorkflowState;
        }

        public String getInitiateId() {
            return InitiateId;
        }

        public void setInitiateId(String InitiateId) {
            this.InitiateId = InitiateId;
        }

        public String getRetreatReason() {
            return RetreatReason;
        }

        public void setRetreatReason(String RetreatReason) {
            this.RetreatReason = RetreatReason;
        }

        public Integer getEvaluationState() {
            return EvaluationState;
        }

        public void setEvaluationState(Integer EvaluationState) {
            this.EvaluationState = EvaluationState;
        }

        public String getEvaluationReason() {
            return EvaluationReason;
        }

        public void setEvaluationReason(String EvaluationReason) {
            this.EvaluationReason = EvaluationReason;
        }

        public Integer getRecordState() {
            return RecordState;
        }

        public void setRecordState(Integer RecordState) {
            this.RecordState = RecordState;
        }

        public Integer getCanSendBack() {
            return CanSendBack;
        }

        public void setCanSendBack(Integer CanSendBack) {
            this.CanSendBack = CanSendBack;
        }

        public Integer getSendBackEndTime() {
            return SendBackEndTime;
        }

        public void setSendBackEndTime(Integer SendBackEndTime) {
            this.SendBackEndTime = SendBackEndTime;
        }

        public Integer getIsLost() {
            return IsLost;
        }

        public void setIsLost(Integer IsLost) {
            this.IsLost = IsLost;
        }

        public Integer getFeedback() {
            return Feedback;
        }

        public void setFeedback(Integer Feedback) {
            this.Feedback = Feedback;
        }

        public String getChangeReason() {
            return ChangeReason;
        }

        public void setChangeReason(String ChangeReason) {
            this.ChangeReason = ChangeReason;
        }
    }
}
