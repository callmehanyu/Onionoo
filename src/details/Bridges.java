package details;

import java.util.List;
public class Bridges
{
    private String nickname;

    private String hashed_fingerprint;

    private List<String> or_addresses;

    private String last_seen;

    private String first_seen;

    private boolean running;

    private List<String> flags;

    private String last_restarted;

    private int advertised_bandwidth;

    private String platform;

    private String version;

    private String version_status;

    private boolean recommended_version;

    private List<String> transports;

    public void setNickname(String nickname){
        this.nickname = nickname;
    }
    public String getNickname(){
        return this.nickname;
    }
    public void setHashed_fingerprint(String hashed_fingerprint){
        this.hashed_fingerprint = hashed_fingerprint;
    }
    public String getHashed_fingerprint(){
        return this.hashed_fingerprint;
    }
    public void setOr_addresses(List<String> or_addresses){
        this.or_addresses = or_addresses;
    }
    public List<String> getOr_addresses(){
        return this.or_addresses;
    }
    public void setLast_seen(String last_seen){
        this.last_seen = last_seen;
    }
    public String getLast_seen(){
        return this.last_seen;
    }
    public void setFirst_seen(String first_seen){
        this.first_seen = first_seen;
    }
    public String getFirst_seen(){
        return this.first_seen;
    }
    public void setRunning(boolean running){
        this.running = running;
    }
    public boolean getRunning(){
        return this.running;
    }
    public void setFlags(List<String> flags){
        this.flags = flags;
    }
    public List<String> getFlags(){
        return this.flags;
    }
    public void setLast_restarted(String last_restarted){
        this.last_restarted = last_restarted;
    }
    public String getLast_restarted(){
        return this.last_restarted;
    }
    public void setAdvertised_bandwidth(int advertised_bandwidth){
        this.advertised_bandwidth = advertised_bandwidth;
    }
    public int getAdvertised_bandwidth(){
        return this.advertised_bandwidth;
    }
    public void setPlatform(String platform){
        this.platform = platform;
    }
    public String getPlatform(){
        return this.platform;
    }
    public void setVersion(String version){
        this.version = version;
    }
    public String getVersion(){
        return this.version;
    }
    public void setVersion_status(String version_status){
        this.version_status = version_status;
    }
    public String getVersion_status(){
        return this.version_status;
    }
    public void setRecommended_version(boolean recommended_version){
        this.recommended_version = recommended_version;
    }
    public boolean getRecommended_version(){
        return this.recommended_version;
    }
    public void setTransports(List<String> transports){
        this.transports = transports;
    }
    public List<String> getTransports(){
        return this.transports;
    }
}