package com.example.finalwork.bean;

import java.util.List;

public class WeatherInfoBean{

    /**
     * reason : 查询成功!
     * result : {"city":"兰州","realtime":{"temperature":"20","humidity":"51","info":"晴","wid":"00","direct":"西风","power":"1级","aqi":"43"},"future":[{"date":"2024-07-01","temperature":"15/28℃","weather":"阵雨转晴","wid":{"day":"03","night":"00"},"direct":"持续无风向"},{"date":"2024-07-02","temperature":"18/29℃","weather":"多云转晴","wid":{"day":"01","night":"00"},"direct":"持续无风向转南风"},{"date":"2024-07-03","temperature":"19/31℃","weather":"晴","wid":{"day":"00","night":"00"},"direct":"东南风"},{"date":"2024-07-04","temperature":"17/31℃","weather":"小雨","wid":{"day":"07","night":"07"},"direct":"西北风转南风"},{"date":"2024-07-05","temperature":"16/29℃","weather":"多云转晴","wid":{"day":"01","night":"00"},"direct":"东北风转西北风"}]}
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
        /**
         * city : 兰州
         * realtime : {"temperature":"20","humidity":"51","info":"晴","wid":"00","direct":"西风","power":"1级","aqi":"43"}
         * future : [{"date":"2024-07-01","temperature":"15/28℃","weather":"阵雨转晴","wid":{"day":"03","night":"00"},"direct":"持续无风向"},{"date":"2024-07-02","temperature":"18/29℃","weather":"多云转晴","wid":{"day":"01","night":"00"},"direct":"持续无风向转南风"},{"date":"2024-07-03","temperature":"19/31℃","weather":"晴","wid":{"day":"00","night":"00"},"direct":"东南风"},{"date":"2024-07-04","temperature":"17/31℃","weather":"小雨","wid":{"day":"07","night":"07"},"direct":"西北风转南风"},{"date":"2024-07-05","temperature":"16/29℃","weather":"多云转晴","wid":{"day":"01","night":"00"},"direct":"东北风转西北风"}]
         */

        private String city;
        private RealtimeDTO realtime;
        private List<FutureDTO> future;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public RealtimeDTO getRealtime() {
            return realtime;
        }

        public void setRealtime(RealtimeDTO realtime) {
            this.realtime = realtime;
        }

        public List<FutureDTO> getFuture() {
            return future;
        }

        public void setFuture(List<FutureDTO> future) {
            this.future = future;
        }

        public static class RealtimeDTO {
            /**
             * temperature : 20
             * humidity : 51
             * info : 晴
             * wid : 00
             * direct : 西风
             * power : 1级
             * aqi : 43
             */

            private String temperature;
            private String humidity;
            private String info;
            private String wid;
            private String direct;
            private String power;
            private String aqi;

            public String getTemperature() {
                return temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }

            public String getHumidity() {
                return humidity;
            }

            public void setHumidity(String humidity) {
                this.humidity = humidity;
            }

            public String getInfo() {
                return info;
            }

            public void setInfo(String info) {
                this.info = info;
            }

            public String getWid() {
                return wid;
            }

            public void setWid(String wid) {
                this.wid = wid;
            }

            public String getDirect() {
                return direct;
            }

            public void setDirect(String direct) {
                this.direct = direct;
            }

            public String getPower() {
                return power;
            }

            public void setPower(String power) {
                this.power = power;
            }

            public String getAqi() {
                return aqi;
            }

            public void setAqi(String aqi) {
                this.aqi = aqi;
            }
        }

        public static class FutureDTO {
            /**
             * date : 2024-07-01
             * temperature : 15/28℃
             * weather : 阵雨转晴
             * wid : {"day":"03","night":"00"}
             * direct : 持续无风向
             */

            private String date;
            private String temperature;
            private String weather;
            private WidDTO wid;
            private String direct;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getTemperature() {
                return temperature;
            }

            public void setTemperature(String temperature) {
                this.temperature = temperature;
            }

            public String getWeather() {
                return weather;
            }

            public void setWeather(String weather) {
                this.weather = weather;
            }

            public WidDTO getWid() {
                return wid;
            }

            public void setWid(WidDTO wid) {
                this.wid = wid;
            }

            public String getDirect() {
                return direct;
            }

            public void setDirect(String direct) {
                this.direct = direct;
            }

            public static class WidDTO {
                /**
                 * day : 03
                 * night : 00
                 */

                private String day;
                private String night;

                public String getDay() {
                    return day;
                }

                public void setDay(String day) {
                    this.day = day;
                }

                public String getNight() {
                    return night;
                }

                public void setNight(String night) {
                    this.night = night;
                }
            }
        }
    }
}