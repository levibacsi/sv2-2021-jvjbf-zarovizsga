package videos;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VideoPlatform {
    private List<Channel> channels = new ArrayList<>();

    public List<Channel> getChannels() {
        return List.copyOf(channels);
    }

    public void readDataFromFile(Path path){
        try {
            Scanner scanner = new Scanner(path);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] temp = line.split(";");
                channels.add(new Channel(temp[0], Integer.parseInt(temp[1]), Integer.parseInt(temp[2])));
            }
        }

         catch (IOException ioe) {
            throw new IllegalStateException("File not found", ioe);
        }
    }

    public int calculateSumOfVideos(){
        return channels.stream()
                .mapToInt(Channel::getNumber_of_videos)
                .sum();
    }


}
