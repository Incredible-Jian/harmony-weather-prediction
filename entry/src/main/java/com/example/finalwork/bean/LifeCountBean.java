package com.example.finalwork.bean;
public class LifeCountBean{
    /**
     * reason : 查询成功!
     * result : {"city":"兰州","life":{"kongtiao":{"v":"较少开启","des":"您将感到很舒适，一般不需要开启空调。"},"guomin":{"v":"易发","des":"天气条件易诱发过敏，有降水，易过敏人群应减少外出，如需外出最好穿长衣长裤，预防感冒可能引发的过敏。"},"shushidu":{"v":"较舒适","des":"白天有降雨，但会使人们感觉有些热，不过大部分人仍会有比较舒适的感觉。"},"chuanyi":{"v":"热","des":"天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。"},"diaoyu":{"v":"不宜","des":"天气不好，不适合垂钓。"},"ganmao":{"v":"少发","des":"各项气象条件适宜，无明显降温过程，发生感冒机率较低。"},"ziwaixian":{"v":"中等","des":"属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。"},"xiche":{"v":"不宜","des":"不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"},"yundong":{"v":"较不宜","des":"有降水，推荐您在室内进行健身休闲运动；若坚持户外运动，须注意携带雨具并注意避雨防滑。"},"daisan":{"v":"带伞","des":"有降水，如果您要短时间外出的话可不必带雨伞。"}}}
     * error_code : 0
     */

    private String reason;
    private ResultDTO result;
    private Integer error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultDTO getResult() {
        return result;
    }

    public void setResult(ResultDTO result) {
        this.result = result;
    }

    public Integer getError_code() {
        return error_code;
    }

    public void setError_code(Integer error_code) {
        this.error_code = error_code;
    }

    public static class ResultDTO {
        public static ResultDTO.LifeDTO LifeDTO;
        /**
         * city : 兰州
         * life : {"kongtiao":{"v":"较少开启","des":"您将感到很舒适，一般不需要开启空调。"},"guomin":{"v":"易发","des":"天气条件易诱发过敏，有降水，易过敏人群应减少外出，如需外出最好穿长衣长裤，预防感冒可能引发的过敏。"},"shushidu":{"v":"较舒适","des":"白天有降雨，但会使人们感觉有些热，不过大部分人仍会有比较舒适的感觉。"},"chuanyi":{"v":"热","des":"天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。"},"diaoyu":{"v":"不宜","des":"天气不好，不适合垂钓。"},"ganmao":{"v":"少发","des":"各项气象条件适宜，无明显降温过程，发生感冒机率较低。"},"ziwaixian":{"v":"中等","des":"属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。"},"xiche":{"v":"不宜","des":"不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"},"yundong":{"v":"较不宜","des":"有降水，推荐您在室内进行健身休闲运动；若坚持户外运动，须注意携带雨具并注意避雨防滑。"},"daisan":{"v":"带伞","des":"有降水，如果您要短时间外出的话可不必带雨伞。"}}
         */

        private String city;
        private LifeDTO life;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public LifeDTO getLife() {
            return life;
        }

        public void setLife(LifeDTO life) {
            this.life = life;
        }

        public static class LifeDTO {
            /**
             * kongtiao : {"v":"较少开启","des":"您将感到很舒适，一般不需要开启空调。"}
             * guomin : {"v":"易发","des":"天气条件易诱发过敏，有降水，易过敏人群应减少外出，如需外出最好穿长衣长裤，预防感冒可能引发的过敏。"}
             * shushidu : {"v":"较舒适","des":"白天有降雨，但会使人们感觉有些热，不过大部分人仍会有比较舒适的感觉。"}
             * chuanyi : {"v":"热","des":"天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。"}
             * diaoyu : {"v":"不宜","des":"天气不好，不适合垂钓。"}
             * ganmao : {"v":"少发","des":"各项气象条件适宜，无明显降温过程，发生感冒机率较低。"}
             * ziwaixian : {"v":"中等","des":"属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。"}
             * xiche : {"v":"不宜","des":"不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。"}
             * yundong : {"v":"较不宜","des":"有降水，推荐您在室内进行健身休闲运动；若坚持户外运动，须注意携带雨具并注意避雨防滑。"}
             * daisan : {"v":"带伞","des":"有降水，如果您要短时间外出的话可不必带雨伞。"}
             */

            private KongtiaoDTO kongtiao;
            private GuominDTO guomin;
            private ShushiduDTO shushidu;
            private ChuanyiDTO chuanyi;
            private DiaoyuDTO diaoyu;
            private GanmaoDTO ganmao;
            private ZiwaixianDTO ziwaixian;
            private XicheDTO xiche;
            private YundongDTO yundong;
            private DaisanDTO daisan;

            public KongtiaoDTO getKongtiao() {
                return kongtiao;
            }

            public void setKongtiao(KongtiaoDTO kongtiao) {
                this.kongtiao = kongtiao;
            }

            public GuominDTO getGuomin() {
                return guomin;
            }

            public void setGuomin(GuominDTO guomin) {
                this.guomin = guomin;
            }

            public ShushiduDTO getShushidu() {
                return shushidu;
            }

            public void setShushidu(ShushiduDTO shushidu) {
                this.shushidu = shushidu;
            }

            public ChuanyiDTO getChuanyi() {
                return chuanyi;
            }

            public void setChuanyi(ChuanyiDTO chuanyi) {
                this.chuanyi = chuanyi;
            }

            public DiaoyuDTO getDiaoyu() {
                return diaoyu;
            }

            public void setDiaoyu(DiaoyuDTO diaoyu) {
                this.diaoyu = diaoyu;
            }

            public GanmaoDTO getGanmao() {
                return ganmao;
            }

            public void setGanmao(GanmaoDTO ganmao) {
                this.ganmao = ganmao;
            }

            public ZiwaixianDTO getZiwaixian() {
                return ziwaixian;
            }

            public void setZiwaixian(ZiwaixianDTO ziwaixian) {
                this.ziwaixian = ziwaixian;
            }

            public XicheDTO getXiche() {
                return xiche;
            }

            public void setXiche(XicheDTO xiche) {
                this.xiche = xiche;
            }

            public YundongDTO getYundong() {
                return yundong;
            }

            public void setYundong(YundongDTO yundong) {
                this.yundong = yundong;
            }

            public DaisanDTO getDaisan() {
                return daisan;
            }

            public void setDaisan(DaisanDTO daisan) {
                this.daisan = daisan;
            }

            public static class KongtiaoDTO {
                /**
                 * v : 较少开启
                 * des : 您将感到很舒适，一般不需要开启空调。
                 */

                private String v;
                private String des;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }

            public static class GuominDTO {
                /**
                 * v : 易发
                 * des : 天气条件易诱发过敏，有降水，易过敏人群应减少外出，如需外出最好穿长衣长裤，预防感冒可能引发的过敏。
                 */

                private String v;
                private String des;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }

            public static class ShushiduDTO {
                /**
                 * v : 较舒适
                 * des : 白天有降雨，但会使人们感觉有些热，不过大部分人仍会有比较舒适的感觉。
                 */

                private String v;
                private String des;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }

            public static class ChuanyiDTO {
                /**
                 * v : 热
                 * des : 天气热，建议着短裙、短裤、短薄外套、T恤等夏季服装。
                 */

                private String v;
                private String des;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }

            public static class DiaoyuDTO {
                /**
                 * v : 不宜
                 * des : 天气不好，不适合垂钓。
                 */

                private String v;
                private String des;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }

            public static class GanmaoDTO {
                /**
                 * v : 少发
                 * des : 各项气象条件适宜，无明显降温过程，发生感冒机率较低。
                 */

                private String v;
                private String des;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }

            public static class ZiwaixianDTO {
                /**
                 * v : 中等
                 * des : 属中等强度紫外线辐射天气，外出时建议涂擦SPF高于15、PA+的防晒护肤品，戴帽子、太阳镜。
                 */

                private String v;
                private String des;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }

            public static class XicheDTO {
                /**
                 * v : 不宜
                 * des : 不宜洗车，未来24小时内有雨，如果在此期间洗车，雨水和路上的泥水可能会再次弄脏您的爱车。
                 */

                private String v;
                private String des;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }

            public static class YundongDTO {
                /**
                 * v : 较不宜
                 * des : 有降水，推荐您在室内进行健身休闲运动；若坚持户外运动，须注意携带雨具并注意避雨防滑。
                 */

                private String v;
                private String des;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }

            public static class DaisanDTO {
                /**
                 * v : 带伞
                 * des : 有降水，如果您要短时间外出的话可不必带雨伞。
                 */

                private String v;
                private String des;

                public String getV() {
                    return v;
                }

                public void setV(String v) {
                    this.v = v;
                }

                public String getDes() {
                    return des;
                }

                public void setDes(String des) {
                    this.des = des;
                }
            }
        }
    }
}