
package retrofitrxandroid.android.com.tutoretrofitrxandroid.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Geo {

    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("lng")
    @Expose
    private String lng;

    /**
     * 
     * @return
     *     The lat
     */
    public String getLat() {
        return lat;
    }

    /**
     * 
     * @param lat
     *     The lat
     */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     * 
     * @return
     *     The lng
     */
    public String getLng() {
        return lng;
    }

    /**
     * 
     * @param lng
     *     The lng
     */
    public void setLng(String lng) {
        this.lng = lng;
    }

}
