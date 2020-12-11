package subway.domain;

public class SectionStation {
    private Station station;
    private SectionStation prevStation;

    public SectionStation(Station station) {
        this.station = station;
    }

    public Station getStation() {
        return station;
    }

    public SectionStation getPrevStation() {
        return prevStation;
    }

    public void setPrevSectionStation(SectionStation sectionStation) {
        prevStation = sectionStation;
    }
}
