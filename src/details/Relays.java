package details;

import java.util.List;
import java.util.Set;

public class Relays
{
    private String nickname;

    private String fingerprint;

    private List<String> or_addresses;

    private String dir_address;

    private String last_seen;

    private String last_changed_address_or_port;

    private String first_seen;

    private boolean running;

    private Set<String> flags;

    private String country;

    private String country_name;

    private String region_name;

    private String city_name;

    private double latitude;

    private double longitude;

    private String as;

    private String as_name;

    private int consensus_weight;

    private List<String> verified_host_names;

    private String last_restarted;

    private int bandwidth_rate;

    private int bandwidth_burst;

    private int observed_bandwidth;

    private int advertised_bandwidth;

    private List<String> exit_policy;

    private Exit_policy_summary exit_policy_summary;

    private String contact;

    private String platform;

    private String version;

    private String version_status;

    private List<String> effective_family;

    private double consensus_weight_fraction;

    private double guard_probability;

    private double middle_probability;

    private double exit_probability;

    private boolean recommended_version;

    private boolean measured;

    public void setNickname(String nickname){
        this.nickname = nickname;
    }
    public String getNickname(){
        return this.nickname;
    }
    public void setFingerprint(String fingerprint){
        this.fingerprint = fingerprint;
    }
    public String getFingerprint(){
        return this.fingerprint;
    }
    public void setOr_addresses(List<String> or_addresses){
        this.or_addresses = or_addresses;
    }
    public List<String> getOr_addresses(){
        return this.or_addresses;
    }
    public void setDir_address(String dir_address){
        this.dir_address = dir_address;
    }
    public String getDir_address(){
        return this.dir_address;
    }
    public void setLast_seen(String last_seen){
        this.last_seen = last_seen;
    }
    public String getLast_seen(){
        return this.last_seen;
    }
    public void setLast_changed_address_or_port(String last_changed_address_or_port){
        this.last_changed_address_or_port = last_changed_address_or_port;
    }
    public String getLast_changed_address_or_port(){
        return this.last_changed_address_or_port;
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
    public void setFlags(Set<String> flags){
        this.flags = flags;
    }
    public Set<String> getFlags(){
        return this.flags;
    }
    public void setCountry(String country){
        this.country = country;
    }
    public String getCountry(){
        return this.country;
    }
    public void setCountry_name(String country_name){
        this.country_name = country_name;
    }
    public String getCountry_name(){
        return this.country_name;
    }
    public void setRegion_name(String region_name){
        this.region_name = region_name;
    }
    public String getRegion_name(){
        return this.region_name;
    }
    public void setCity_name(String city_name){
        this.city_name = city_name;
    }
    public String getCity_name(){
        return this.city_name;
    }
    public void setLatitude(double latitude){
        this.latitude = latitude;
    }
    public double getLatitude(){
        return this.latitude;
    }
    public void setLongitude(double longitude){
        this.longitude = longitude;
    }
    public double getLongitude(){
        return this.longitude;
    }
    public void setAs(String as){
        this.as = as;
    }
    public String getAs(){
        return this.as;
    }
    public void setAs_name(String as_name){
        this.as_name = as_name;
    }
    public String getAs_name(){
        return this.as_name;
    }
    public void setConsensus_weight(int consensus_weight){
        this.consensus_weight = consensus_weight;
    }
    public int getConsensus_weight(){
        return this.consensus_weight;
    }
    public void setVerified_host_names(List<String> verified_host_names){
        this.verified_host_names = verified_host_names;
    }
    public List<String> getVerified_host_names(){
        return this.verified_host_names;
    }
    public void setLast_restarted(String last_restarted){
        this.last_restarted = last_restarted;
    }
    public String getLast_restarted(){
        return this.last_restarted;
    }
    public void setBandwidth_rate(int bandwidth_rate){
        this.bandwidth_rate = bandwidth_rate;
    }
    public int getBandwidth_rate(){
        return this.bandwidth_rate;
    }
    public void setBandwidth_burst(int bandwidth_burst){
        this.bandwidth_burst = bandwidth_burst;
    }
    public int getBandwidth_burst(){
        return this.bandwidth_burst;
    }
    public void setObserved_bandwidth(int observed_bandwidth){
        this.observed_bandwidth = observed_bandwidth;
    }
    public int getObserved_bandwidth(){
        return this.observed_bandwidth;
    }
    public void setAdvertised_bandwidth(int advertised_bandwidth){
        this.advertised_bandwidth = advertised_bandwidth;
    }
    public int getAdvertised_bandwidth(){
        return this.advertised_bandwidth;
    }
    public void setExit_policy(List<String> exit_policy){
        this.exit_policy = exit_policy;
    }
    public List<String> getExit_policy(){
        return this.exit_policy;
    }
    public void setExit_policy_summary(Exit_policy_summary exit_policy_summary){
        this.exit_policy_summary = exit_policy_summary;
    }
    public Exit_policy_summary getExit_policy_summary(){
        return this.exit_policy_summary;
    }
    public void setContact(String contact){
        this.contact = contact;
    }
    public String getContact(){
        return this.contact;
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
    public void setEffective_family(List<String> effective_family){
        this.effective_family = effective_family;
    }
    public List<String> getEffective_family(){
        return this.effective_family;
    }
    public void setConsensus_weight_fraction(double consensus_weight_fraction){
        this.consensus_weight_fraction = consensus_weight_fraction;
    }
    public double getConsensus_weight_fraction(){
        return this.consensus_weight_fraction;
    }
    public void setGuard_probability(double guard_probability){
        this.guard_probability = guard_probability;
    }
    public double getGuard_probability(){
        return this.guard_probability;
    }
    public void setMiddle_probability(double middle_probability){
        this.middle_probability = middle_probability;
    }
    public double getMiddle_probability(){
        return this.middle_probability;
    }
    public void setExit_probability(double exit_probability){
        this.exit_probability = exit_probability;
    }
    public double getExit_probability(){
        return this.exit_probability;
    }
    public void setRecommended_version(boolean recommended_version){
        this.recommended_version = recommended_version;
    }
    public boolean getRecommended_version(){
        return this.recommended_version;
    }
    public void setMeasured(boolean measured){
        this.measured = measured;
    }
    public boolean getMeasured(){
        return this.measured;
    }
}
