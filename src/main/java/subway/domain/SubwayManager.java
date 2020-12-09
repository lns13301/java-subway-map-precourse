package subway.domain;

import subway.view.OutputView;

import java.util.Scanner;

public class SubwayManager {
    public void startProgram() {
        State state = State.MAIN_SCENE;

        do {

        } while (state != State.QUIT);
    }

    public void showMainScene() {
        OutputView.printMainScene();
        OutputView.printChoiceFunction();
    }

    public void showStationScene() {
        OutputView.printStationManagementScene();
        OutputView.printChoiceFunction();
    }

    public void showLineScene() {
        OutputView.printLineScene();
        OutputView.printChoiceFunction();
    }

    public void showSectionScene() {
        OutputView.printSectionScene();
        OutputView.printChoiceFunction();
    }

    public void addStation(String name) {
        StationRepository.addStation(new Station(name));
        OutputView.printRegisteredStationMessage();
    }

    public void removeStation(String name) {
        StationRepository.deleteStation(name);
        OutputView.printRemovedStationMessage();
    }

    public void inquiryStation() {
        OutputView.printStationList(StationRepository.stations());
    }

    public void addLine(String name, Scanner scanner) {
        Line line = new Line(name);

        setLineUpStation(line, scanner);
        setLineDownStation(line, scanner);

        LineRepository.addLine(line);
        OutputView.printRegisteredLineMessage();
    }

    private void setLineUpStation(Line line, Scanner scanner) {
        OutputView.printInputRegisterLineUpStation();
        line.addStation(StationRepository.findStationByName(scanner.next()));
    }

    private void setLineDownStation(Line line, Scanner scanner) {
        OutputView.printInputRegisterLineDownStation();
        line.addStation(StationRepository.findStationByName(scanner.next()));
    }

    public void removeLine(String name) {
        LineRepository.deleteLineByName(name);
        OutputView.printRemovedLineMessage();
    }
    
    public void inquiryLine() {
        OutputView.printLineList(LineRepository.lines());
    }

    public void registerSection(Scanner scanner) {
        findLineToRegister(
                scanner.next()).addStation(findStationToRegister(scanner.next()), getRegisterIndex(scanner.next()));
        OutputView.printRegisteredSectionMessage();
    }

    public void removeSection(Scanner scanner) {
        findLineToRemove(scanner.next()).deleteStation(findStationToRemove(scanner.next()).getName());
        OutputView.printRemovedSectionMessage();
    }

    private Line findLineToRegister(String name) {
        OutputView.printInputLine();

        return LineRepository.findLineByName(name);
    }

    private Station findStationToRegister(String name) {
        OutputView.printInputStation();

        return StationRepository.findStationByName(name);
    }

    private Line findLineToRemove(String name) {
        OutputView.printInputRemoveSectionLine();

        return LineRepository.findLineByName(name);
    }

    private Station findStationToRemove(String name) {
        OutputView.printInputRemoveSectionStation();

        return StationRepository.findStationByName(name);
    }

    private int getRegisterIndex(String index) {
        return Integer.parseInt(index);
    }

    public void inquirySubwayMap() {
        LineRepository.lines().forEach(OutputView::printSubwayMap);
    }
}
