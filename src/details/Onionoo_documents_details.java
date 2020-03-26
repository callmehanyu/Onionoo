package details;

import java.util.List;

public class Onionoo_documents_details {
    private String version;

    private String next_major_version_scheduled;

    private String build_revision;

    private String relays_published;

    private List<Relays> relays;

    private String bridges_published;

    private List<Bridges> bridges;

    public void setVersion(String version){
        this.version = version;
    }
    public String getVersion(){
        return this.version;
    }
    public void setNext_major_version_scheduled(String next_major_version_scheduled){
        this.next_major_version_scheduled = next_major_version_scheduled;
    }
    public String getNext_major_version_scheduled(){
        return this.next_major_version_scheduled;
    }
    public void setBuild_revision(String build_revision){
        this.build_revision = build_revision;
    }
    public String getBuild_revision(){
        return this.build_revision;
    }
    public void setRelays_published(String relays_published){
        this.relays_published = relays_published;
    }
    public String getRelays_published(){
        return this.relays_published;
    }
    public void setRelays(List<Relays> relays){
        this.relays = relays;
    }
    public List<Relays> getRelays(){
        return this.relays;
    }
    public void setBridges_published(String bridges_published){
        this.bridges_published = bridges_published;
    }
    public String getBridges_published(){
        return this.bridges_published;
    }
    public void setBridges(List<Bridges> bridges){
        this.bridges = bridges;
    }
    public List<Bridges> getBridges(){
        return this.bridges;
    }
}
