package org.example.sheet7;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

 class TennisStatsAnalyzer extends Application {
    private List<Player> players = new ArrayList<>();
    private TennisStatisticsAnalyzer analyzer = new TennisStatisticsAnalyzer();

    private Label winningPercentageLabel;
    private Label mostWinsLabel;
    private Label highestLossesLabel;
    private Label winningRecordLabel;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Tennis Stats Analyzer");

        BorderPane borderPane = new BorderPane();
        ListView<String> listView = new ListView<>();
        listView.setOnMouseClicked(e -> showWinningPercentage(listView.getSelectionModel().getSelectedItem()));

        Button loadButton = new Button("Load Players");
        loadButton.setOnAction(e -> loadPlayersFromFile(listView));

        winningPercentageLabel = new Label();
        mostWinsLabel = new Label();
        highestLossesLabel = new Label();
        winningRecordLabel = new Label();

        HBox buttons = new HBox(10);
        buttons.getChildren().addAll(loadButton);

        borderPane.setTop(buttons);
        borderPane.setCenter(listView);
        borderPane.setLeft(winningPercentageLabel);
        borderPane.setRight(mostWinsLabel);
        borderPane.setBottom(highestLossesLabel);
        borderPane.setRight(winningRecordLabel);

        Scene scene = new Scene(borderPane, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void loadPlayersFromFile(ListView<String> listView) {
        players.clear();
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 3) {
                        String name = parts[0];
                        int wins = Integer.parseInt(parts[1]);
                        int losses = Integer.parseInt(parts[2]);
                        players.add(new Player(name, wins, losses));
                        listView.getItems().add(name);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showWinningPercentage(String playerName) {
        if (playerName != null && !playerName.isEmpty()) {
            for (Player player : players) {
                if (player.getName().equals(playerName)) {
                    double winningPercentage = analyzer.calculateWinningPercentage(player);
                    winningPercentageLabel.setText(playerName + "'s Winning Percentage: " + winningPercentage + "%");
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

class TennisStatisticsAnalyzer {
    public double calculateWinningPercentage(Player player) {
        if (player.getWins() + player.getLosses() == 0) {
            return 0;
        }
        return ((double) player.getWins() / (player.getWins() + player.getLosses())) * 100;
    }

    public String playerWithMostWins(List<Player> players) {
        Player mostWinsPlayer = players.get(0);
        for (Player player : players) {
            if (player.getWins() > mostWinsPlayer.getWins()) {
                mostWinsPlayer = player;
            }
        }
        return mostWinsPlayer.getName();
    }

    public String playerWithHighestLossesPercentage(List<Player> players) {
        Player highestLossesPlayer = players.get(0);
        for (Player player : players) {
            if (calculateWinningPercentage(player) < calculateWinningPercentage(highestLossesPlayer)) {
                highestLossesPlayer = player;
            }
        }
        return highestLossesPlayer.getName();
    }

    public int numberOfPlayersWithWinningRecord(List<Player> players) {
        int count = 0;
        for (Player player : players) {
            if (player.getWins() > player.getLosses()) {
                count++;
            }
        }
        return count;
    }
}

class Player {
    private String name;
    private int wins;
    private int losses;

    public Player(String name, int wins, int losses) {
        this.name = name;
        this.wins = wins;
        this.losses = losses;
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }
}
