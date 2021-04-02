package com.yiban.test.model.bean;

import com.google.gson.annotations.SerializedName;

public class LoginResult {
    /**
     * response : 100
     * message : 请求成功
     * data : {"user":{"sex":"M","name":"郑梓鸿","nick":"郑梓鸿","pic_s":"http://img02.fs.yiban.cn/30231200/avatar/user/68","pic_b":"http://img02.fs.yiban.cn/30231200/avatar/user/160","phone":"15992266476","source":"大学","user_id":"30231200","isPublic":"0","qrIndex":"aW5kZXg6MzAyMzEyMDA=","authority":"1","feedsClose":"0","shieldName":"0","shieldFeeds":"0","shieldMobile":"0","hiddenPushMsg":"0","maskedStranger":"0","allowRecommend":"1","isOrganization":"0","isSchoolVerify":"1","school_id":"18105","provinceOrgId":"7933855","schoolOrganization":{"pic_s":"http://img02.fs.yiban.cn/11249929/avatar/user/68","pic_b":"http://img02.fs.yiban.cn/11249929/avatar/user/160","brief":"江门职业技术学院是一所综合性的公办全日制普通高等学校。设有材料技术、电子与信息技术、经济管理、机电技术、教育与教育技术、外语、艺术设计和思想政治理论课教学部等8个教学系部，开设涉及理、工、文、管与艺术类的42个专业（82个专业方向）；学校注重学生职业素质训练，近年来，学生在全国、全省各类技能比赛中频频获奖，在\u201c挑战杯\u201d比赛中，连续五届捧得优胜杯。2018年全国职业院校技能大赛我校获奖数量12个，全国排第28名。学院坚持对外开放办学，与澳大利亚、新西兰、韩国、香港等国家（地区）的同类院校进行广泛的交流与合作。","user_id":"11249929","school_id":"18105","publicName":"江门职业技术学院","school_name":"江门职业技术学院","isAdministrative":"1","background":{"b":"http://img01.fs.yiban.cn/mobile/1PTESD","o":"http://img01.fs.yiban.cn/mobile/1PTES9","m":"http://img01.fs.yiban.cn/mobile/1PTESB"}},"schoolInfo":{"school_id":"18105","school_name":"江门职业技术学院","user_id":"11249929"},"groupInfo":{"id":"673588","auth":"2","name":"信息工程学院","user_id":"11249929"}},"token":"51e09aa69b29c07713d762f978f25ca6","oauth2_access_token":"3eb384c2e9122c5e2da795eb7ba7ea73b9d8ae66","doubleCheck":"false","updateAction":"false","access_token":"57be051332fc02b666dfef0b9c4bc550","avatar_server":"http://img02.fs.yiban.cn","voice_app_url":"http://mobile.yiban.cn/api/voice/index?access_token=57be051332fc02b666dfef0b9c4bc550","web_accesstoken_login_url":"http://www.yiban.cn/login/accessTokenLogin?access_token=57be051332fc02b666dfef0b9c4bc550","universities_import_time_url":"http://q.yiban.cn/app/index/appid/135575","redirect":""}
     */

    @SerializedName("response")
    private String response;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private DataDTO data;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public static class DataDTO {
        /**
         * user : {"sex":"M","name":"郑梓鸿","nick":"郑梓鸿","pic_s":"http://img02.fs.yiban.cn/30231200/avatar/user/68","pic_b":"http://img02.fs.yiban.cn/30231200/avatar/user/160","phone":"15992266476","source":"大学","user_id":"30231200","isPublic":"0","qrIndex":"aW5kZXg6MzAyMzEyMDA=","authority":"1","feedsClose":"0","shieldName":"0","shieldFeeds":"0","shieldMobile":"0","hiddenPushMsg":"0","maskedStranger":"0","allowRecommend":"1","isOrganization":"0","isSchoolVerify":"1","school_id":"18105","provinceOrgId":"7933855","schoolOrganization":{"pic_s":"http://img02.fs.yiban.cn/11249929/avatar/user/68","pic_b":"http://img02.fs.yiban.cn/11249929/avatar/user/160","brief":"江门职业技术学院是一所综合性的公办全日制普通高等学校。设有材料技术、电子与信息技术、经济管理、机电技术、教育与教育技术、外语、艺术设计和思想政治理论课教学部等8个教学系部，开设涉及理、工、文、管与艺术类的42个专业（82个专业方向）；学校注重学生职业素质训练，近年来，学生在全国、全省各类技能比赛中频频获奖，在\u201c挑战杯\u201d比赛中，连续五届捧得优胜杯。2018年全国职业院校技能大赛我校获奖数量12个，全国排第28名。学院坚持对外开放办学，与澳大利亚、新西兰、韩国、香港等国家（地区）的同类院校进行广泛的交流与合作。","user_id":"11249929","school_id":"18105","publicName":"江门职业技术学院","school_name":"江门职业技术学院","isAdministrative":"1","background":{"b":"http://img01.fs.yiban.cn/mobile/1PTESD","o":"http://img01.fs.yiban.cn/mobile/1PTES9","m":"http://img01.fs.yiban.cn/mobile/1PTESB"}},"schoolInfo":{"school_id":"18105","school_name":"江门职业技术学院","user_id":"11249929"},"groupInfo":{"id":"673588","auth":"2","name":"信息工程学院","user_id":"11249929"}}
         * token : 51e09aa69b29c07713d762f978f25ca6
         * oauth2_access_token : 3eb384c2e9122c5e2da795eb7ba7ea73b9d8ae66
         * doubleCheck : false
         * updateAction : false
         * access_token : 57be051332fc02b666dfef0b9c4bc550
         * avatar_server : http://img02.fs.yiban.cn
         * voice_app_url : http://mobile.yiban.cn/api/voice/index?access_token=57be051332fc02b666dfef0b9c4bc550
         * web_accesstoken_login_url : http://www.yiban.cn/login/accessTokenLogin?access_token=57be051332fc02b666dfef0b9c4bc550
         * universities_import_time_url : http://q.yiban.cn/app/index/appid/135575
         * redirect :
         */

        @SerializedName("user")
        private UserDTO user;
        @SerializedName("token")
        private String token;
        @SerializedName("oauth2_access_token")
        private String oauth2AccessToken;
        @SerializedName("doubleCheck")
        private String doubleCheck;
        @SerializedName("updateAction")
        private String updateAction;
        @SerializedName("access_token")
        private String accessToken;
        @SerializedName("avatar_server")
        private String avatarServer;
        @SerializedName("voice_app_url")
        private String voiceAppUrl;
        @SerializedName("web_accesstoken_login_url")
        private String webAccesstokenLoginUrl;
        @SerializedName("universities_import_time_url")
        private String universitiesImportTimeUrl;
        @SerializedName("redirect")
        private String redirect;

        public UserDTO getUser() {
            return user;
        }

        public void setUser(UserDTO user) {
            this.user = user;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getOauth2AccessToken() {
            return oauth2AccessToken;
        }

        public void setOauth2AccessToken(String oauth2AccessToken) {
            this.oauth2AccessToken = oauth2AccessToken;
        }

        public String getDoubleCheck() {
            return doubleCheck;
        }

        public void setDoubleCheck(String doubleCheck) {
            this.doubleCheck = doubleCheck;
        }

        public String getUpdateAction() {
            return updateAction;
        }

        public void setUpdateAction(String updateAction) {
            this.updateAction = updateAction;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public String getAvatarServer() {
            return avatarServer;
        }

        public void setAvatarServer(String avatarServer) {
            this.avatarServer = avatarServer;
        }

        public String getVoiceAppUrl() {
            return voiceAppUrl;
        }

        public void setVoiceAppUrl(String voiceAppUrl) {
            this.voiceAppUrl = voiceAppUrl;
        }

        public String getWebAccesstokenLoginUrl() {
            return webAccesstokenLoginUrl;
        }

        public void setWebAccesstokenLoginUrl(String webAccesstokenLoginUrl) {
            this.webAccesstokenLoginUrl = webAccesstokenLoginUrl;
        }

        public String getUniversitiesImportTimeUrl() {
            return universitiesImportTimeUrl;
        }

        public void setUniversitiesImportTimeUrl(String universitiesImportTimeUrl) {
            this.universitiesImportTimeUrl = universitiesImportTimeUrl;
        }

        public String getRedirect() {
            return redirect;
        }

        public void setRedirect(String redirect) {
            this.redirect = redirect;
        }

        public static class UserDTO {
            /**
             * sex : M
             * name : 郑梓鸿
             * nick : 郑梓鸿
             * pic_s : http://img02.fs.yiban.cn/30231200/avatar/user/68
             * pic_b : http://img02.fs.yiban.cn/30231200/avatar/user/160
             * phone : 15992266476
             * source : 大学
             * user_id : 30231200
             * isPublic : 0
             * qrIndex : aW5kZXg6MzAyMzEyMDA=
             * authority : 1
             * feedsClose : 0
             * shieldName : 0
             * shieldFeeds : 0
             * shieldMobile : 0
             * hiddenPushMsg : 0
             * maskedStranger : 0
             * allowRecommend : 1
             * isOrganization : 0
             * isSchoolVerify : 1
             * school_id : 18105
             * provinceOrgId : 7933855
             * schoolOrganization : {"pic_s":"http://img02.fs.yiban.cn/11249929/avatar/user/68","pic_b":"http://img02.fs.yiban.cn/11249929/avatar/user/160","brief":"江门职业技术学院是一所综合性的公办全日制普通高等学校。设有材料技术、电子与信息技术、经济管理、机电技术、教育与教育技术、外语、艺术设计和思想政治理论课教学部等8个教学系部，开设涉及理、工、文、管与艺术类的42个专业（82个专业方向）；学校注重学生职业素质训练，近年来，学生在全国、全省各类技能比赛中频频获奖，在\u201c挑战杯\u201d比赛中，连续五届捧得优胜杯。2018年全国职业院校技能大赛我校获奖数量12个，全国排第28名。学院坚持对外开放办学，与澳大利亚、新西兰、韩国、香港等国家（地区）的同类院校进行广泛的交流与合作。","user_id":"11249929","school_id":"18105","publicName":"江门职业技术学院","school_name":"江门职业技术学院","isAdministrative":"1","background":{"b":"http://img01.fs.yiban.cn/mobile/1PTESD","o":"http://img01.fs.yiban.cn/mobile/1PTES9","m":"http://img01.fs.yiban.cn/mobile/1PTESB"}}
             * schoolInfo : {"school_id":"18105","school_name":"江门职业技术学院","user_id":"11249929"}
             * groupInfo : {"id":"673588","auth":"2","name":"信息工程学院","user_id":"11249929"}
             */

            @SerializedName("sex")
            private String sex;
            @SerializedName("name")
            private String name;
            @SerializedName("nick")
            private String nick;
            @SerializedName("pic_s")
            private String picS;
            @SerializedName("pic_b")
            private String picB;
            @SerializedName("phone")
            private String phone;
            @SerializedName("source")
            private String source;
            @SerializedName("user_id")
            private String userId;
            @SerializedName("isPublic")
            private String isPublic;
            @SerializedName("qrIndex")
            private String qrIndex;
            @SerializedName("authority")
            private String authority;
            @SerializedName("feedsClose")
            private String feedsClose;
            @SerializedName("shieldName")
            private String shieldName;
            @SerializedName("shieldFeeds")
            private String shieldFeeds;
            @SerializedName("shieldMobile")
            private String shieldMobile;
            @SerializedName("hiddenPushMsg")
            private String hiddenPushMsg;
            @SerializedName("maskedStranger")
            private String maskedStranger;
            @SerializedName("allowRecommend")
            private String allowRecommend;
            @SerializedName("isOrganization")
            private String isOrganization;
            @SerializedName("isSchoolVerify")
            private String isSchoolVerify;
            @SerializedName("school_id")
            private String schoolId;
            @SerializedName("provinceOrgId")
            private String provinceOrgId;
            @SerializedName("schoolOrganization")
            private SchoolOrganizationDTO schoolOrganization;
            @SerializedName("schoolInfo")
            private SchoolInfoDTO schoolInfo;
            @SerializedName("groupInfo")
            private GroupInfoDTO groupInfo;

            public String getSex() {
                return sex;
            }

            public void setSex(String sex) {
                this.sex = sex;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getNick() {
                return nick;
            }

            public void setNick(String nick) {
                this.nick = nick;
            }

            public String getPicS() {
                return picS;
            }

            public void setPicS(String picS) {
                this.picS = picS;
            }

            public String getPicB() {
                return picB;
            }

            public void setPicB(String picB) {
                this.picB = picB;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getSource() {
                return source;
            }

            public void setSource(String source) {
                this.source = source;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getIsPublic() {
                return isPublic;
            }

            public void setIsPublic(String isPublic) {
                this.isPublic = isPublic;
            }

            public String getQrIndex() {
                return qrIndex;
            }

            public void setQrIndex(String qrIndex) {
                this.qrIndex = qrIndex;
            }

            public String getAuthority() {
                return authority;
            }

            public void setAuthority(String authority) {
                this.authority = authority;
            }

            public String getFeedsClose() {
                return feedsClose;
            }

            public void setFeedsClose(String feedsClose) {
                this.feedsClose = feedsClose;
            }

            public String getShieldName() {
                return shieldName;
            }

            public void setShieldName(String shieldName) {
                this.shieldName = shieldName;
            }

            public String getShieldFeeds() {
                return shieldFeeds;
            }

            public void setShieldFeeds(String shieldFeeds) {
                this.shieldFeeds = shieldFeeds;
            }

            public String getShieldMobile() {
                return shieldMobile;
            }

            public void setShieldMobile(String shieldMobile) {
                this.shieldMobile = shieldMobile;
            }

            public String getHiddenPushMsg() {
                return hiddenPushMsg;
            }

            public void setHiddenPushMsg(String hiddenPushMsg) {
                this.hiddenPushMsg = hiddenPushMsg;
            }

            public String getMaskedStranger() {
                return maskedStranger;
            }

            public void setMaskedStranger(String maskedStranger) {
                this.maskedStranger = maskedStranger;
            }

            public String getAllowRecommend() {
                return allowRecommend;
            }

            public void setAllowRecommend(String allowRecommend) {
                this.allowRecommend = allowRecommend;
            }

            public String getIsOrganization() {
                return isOrganization;
            }

            public void setIsOrganization(String isOrganization) {
                this.isOrganization = isOrganization;
            }

            public String getIsSchoolVerify() {
                return isSchoolVerify;
            }

            public void setIsSchoolVerify(String isSchoolVerify) {
                this.isSchoolVerify = isSchoolVerify;
            }

            public String getSchoolId() {
                return schoolId;
            }

            public void setSchoolId(String schoolId) {
                this.schoolId = schoolId;
            }

            public String getProvinceOrgId() {
                return provinceOrgId;
            }

            public void setProvinceOrgId(String provinceOrgId) {
                this.provinceOrgId = provinceOrgId;
            }

            public SchoolOrganizationDTO getSchoolOrganization() {
                return schoolOrganization;
            }

            public void setSchoolOrganization(SchoolOrganizationDTO schoolOrganization) {
                this.schoolOrganization = schoolOrganization;
            }

            public SchoolInfoDTO getSchoolInfo() {
                return schoolInfo;
            }

            public void setSchoolInfo(SchoolInfoDTO schoolInfo) {
                this.schoolInfo = schoolInfo;
            }

            public GroupInfoDTO getGroupInfo() {
                return groupInfo;
            }

            public void setGroupInfo(GroupInfoDTO groupInfo) {
                this.groupInfo = groupInfo;
            }

            public static class SchoolOrganizationDTO {
                /**
                 * pic_s : http://img02.fs.yiban.cn/11249929/avatar/user/68
                 * pic_b : http://img02.fs.yiban.cn/11249929/avatar/user/160
                 * brief : 江门职业技术学院是一所综合性的公办全日制普通高等学校。设有材料技术、电子与信息技术、经济管理、机电技术、教育与教育技术、外语、艺术设计和思想政治理论课教学部等8个教学系部，开设涉及理、工、文、管与艺术类的42个专业（82个专业方向）；学校注重学生职业素质训练，近年来，学生在全国、全省各类技能比赛中频频获奖，在“挑战杯”比赛中，连续五届捧得优胜杯。2018年全国职业院校技能大赛我校获奖数量12个，全国排第28名。学院坚持对外开放办学，与澳大利亚、新西兰、韩国、香港等国家（地区）的同类院校进行广泛的交流与合作。
                 * user_id : 11249929
                 * school_id : 18105
                 * publicName : 江门职业技术学院
                 * school_name : 江门职业技术学院
                 * isAdministrative : 1
                 * background : {"b":"http://img01.fs.yiban.cn/mobile/1PTESD","o":"http://img01.fs.yiban.cn/mobile/1PTES9","m":"http://img01.fs.yiban.cn/mobile/1PTESB"}
                 */

                @SerializedName("pic_s")
                private String picS;
                @SerializedName("pic_b")
                private String picB;
                @SerializedName("brief")
                private String brief;
                @SerializedName("user_id")
                private String userId;
                @SerializedName("school_id")
                private String schoolId;
                @SerializedName("publicName")
                private String publicName;
                @SerializedName("school_name")
                private String schoolName;
                @SerializedName("isAdministrative")
                private String isAdministrative;
                @SerializedName("background")
                private BackgroundDTO background;

                public String getPicS() {
                    return picS;
                }

                public void setPicS(String picS) {
                    this.picS = picS;
                }

                public String getPicB() {
                    return picB;
                }

                public void setPicB(String picB) {
                    this.picB = picB;
                }

                public String getBrief() {
                    return brief;
                }

                public void setBrief(String brief) {
                    this.brief = brief;
                }

                public String getUserId() {
                    return userId;
                }

                public void setUserId(String userId) {
                    this.userId = userId;
                }

                public String getSchoolId() {
                    return schoolId;
                }

                public void setSchoolId(String schoolId) {
                    this.schoolId = schoolId;
                }

                public String getPublicName() {
                    return publicName;
                }

                public void setPublicName(String publicName) {
                    this.publicName = publicName;
                }

                public String getSchoolName() {
                    return schoolName;
                }

                public void setSchoolName(String schoolName) {
                    this.schoolName = schoolName;
                }

                public String getIsAdministrative() {
                    return isAdministrative;
                }

                public void setIsAdministrative(String isAdministrative) {
                    this.isAdministrative = isAdministrative;
                }

                public BackgroundDTO getBackground() {
                    return background;
                }

                public void setBackground(BackgroundDTO background) {
                    this.background = background;
                }

                public static class BackgroundDTO {
                    /**
                     * b : http://img01.fs.yiban.cn/mobile/1PTESD
                     * o : http://img01.fs.yiban.cn/mobile/1PTES9
                     * m : http://img01.fs.yiban.cn/mobile/1PTESB
                     */

                    @SerializedName("b")
                    private String b;
                    @SerializedName("o")
                    private String o;
                    @SerializedName("m")
                    private String m;

                    public String getB() {
                        return b;
                    }

                    public void setB(String b) {
                        this.b = b;
                    }

                    public String getO() {
                        return o;
                    }

                    public void setO(String o) {
                        this.o = o;
                    }

                    public String getM() {
                        return m;
                    }

                    public void setM(String m) {
                        this.m = m;
                    }
                }
            }

            public static class SchoolInfoDTO {
                /**
                 * school_id : 18105
                 * school_name : 江门职业技术学院
                 * user_id : 11249929
                 */

                @SerializedName("school_id")
                private String schoolId;
                @SerializedName("school_name")
                private String schoolName;
                @SerializedName("user_id")
                private String userId;

                public String getSchoolId() {
                    return schoolId;
                }

                public void setSchoolId(String schoolId) {
                    this.schoolId = schoolId;
                }

                public String getSchoolName() {
                    return schoolName;
                }

                public void setSchoolName(String schoolName) {
                    this.schoolName = schoolName;
                }

                public String getUserId() {
                    return userId;
                }

                public void setUserId(String userId) {
                    this.userId = userId;
                }
            }

            public static class GroupInfoDTO {
                /**
                 * id : 673588
                 * auth : 2
                 * name : 信息工程学院
                 * user_id : 11249929
                 */

                @SerializedName("id")
                private String id;
                @SerializedName("auth")
                private String auth;
                @SerializedName("name")
                private String name;
                @SerializedName("user_id")
                private String userId;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getAuth() {
                    return auth;
                }

                public void setAuth(String auth) {
                    this.auth = auth;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getUserId() {
                    return userId;
                }

                public void setUserId(String userId) {
                    this.userId = userId;
                }
            }
        }
    }
}
