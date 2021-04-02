package com.yiban.test.model.bean;

import java.util.List;

public class UncompletedTask {
    /**
     * code : 0
     * msg :
     * data : [{"TaskId":"43406198308a7d716418df16422357e7","OrgId":"","TimeoutState":1,"State":0,"Title":"3月20日晚检","Type":1,"StartTime":1616232600,"EndTime":1616248800},{"TaskId":"2bed78407d0a62e16e9887d6c47d8b0b","OrgId":"","TimeoutState":2,"State":0,"Title":"3月20日午检","Type":1,"StartTime":1616209200,"EndTime":1616225400},{"TaskId":"28668ebc2231761d725e517bc88f9e8e","OrgId":"","TimeoutState":2,"State":0,"Title":"3月20日晨检","Type":1,"StartTime":1616194800,"EndTime":1616207400},{"TaskId":"77df37bb3d45b3b3a905b7a275c574e5","OrgId":"","TimeoutState":2,"State":0,"Title":"3月19日晚检","Type":1,"StartTime":1616146200,"EndTime":1616162400},{"TaskId":"b03a940a69ddf5c4b1783bf7f5e6d8c4","OrgId":"","TimeoutState":2,"State":0,"Title":"3月19日午检","Type":1,"StartTime":1616122800,"EndTime":1616139000},{"TaskId":"ea5b558c79c9db1a81d0a962933113ef","OrgId":"","TimeoutState":2,"State":0,"Title":"3月19日晨检","Type":1,"StartTime":1616108400,"EndTime":1616121000},{"TaskId":"7b70768c74df0429ad7289b2351a710a","OrgId":"","TimeoutState":2,"State":0,"Title":"3月18日晚检","Type":1,"StartTime":1616059800,"EndTime":1616076000},{"TaskId":"9a01b0244fc9e9b6c16e50b5b177b62a","OrgId":"","TimeoutState":2,"State":0,"Title":"3月18日午检","Type":1,"StartTime":1616036400,"EndTime":1616052600},{"TaskId":"008815d502ccd0864162ba1e382232af","OrgId":"","TimeoutState":2,"State":0,"Title":"3月17日晚检","Type":1,"StartTime":1615973400,"EndTime":1615989600}]
     */

    @com.google.gson.annotations.SerializedName("code")
    private Integer code;
    @com.google.gson.annotations.SerializedName("msg")
    private String msg;
    @com.google.gson.annotations.SerializedName("data")
    private List<DataDTO> data;

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

    public List<DataDTO> getData() {
        return data;
    }

    public void setData(List<DataDTO> data) {
        this.data = data;
    }

    public static class DataDTO {
        /**
         * TaskId : 43406198308a7d716418df16422357e7
         * OrgId :
         * TimeoutState : 1
         * State : 0
         * Title : 3月20日晚检
         * Type : 1
         * StartTime : 1616232600
         * EndTime : 1616248800
         */

        @com.google.gson.annotations.SerializedName("TaskId")
        private String TaskId;
        @com.google.gson.annotations.SerializedName("OrgId")
        private String OrgId;
        @com.google.gson.annotations.SerializedName("TimeoutState")
        private Integer TimeoutState;
        @com.google.gson.annotations.SerializedName("State")
        private Integer State;
        @com.google.gson.annotations.SerializedName("Title")
        private String Title;
        @com.google.gson.annotations.SerializedName("Type")
        private Integer Type;
        @com.google.gson.annotations.SerializedName("StartTime")
        private Integer StartTime;
        @com.google.gson.annotations.SerializedName("EndTime")
        private Integer EndTime;

        public String getTaskId() {
            return TaskId;
        }

        public void setTaskId(String TaskId) {
            this.TaskId = TaskId;
        }

        public String getOrgId() {
            return OrgId;
        }

        public void setOrgId(String OrgId) {
            this.OrgId = OrgId;
        }

        public Integer getTimeoutState() {
            return TimeoutState;
        }

        public void setTimeoutState(Integer TimeoutState) {
            this.TimeoutState = TimeoutState;
        }

        public Integer getState() {
            return State;
        }

        public void setState(Integer State) {
            this.State = State;
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
    }
}
