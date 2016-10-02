package com.cworks.goeuro.csvcreation;

import com.cworks.goeuro.json.jsonEntities.GoEuroLocation;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * This class is responsibel for creation of File
 * Created by chandra on 02-10-2016.
 */
@Service
public class GoEuroFileService {



    public static final String STR = "\"";
    private static final String FOLDER = "/goeuro/";
    private static final String FOLDER_SEPERATOR = "/";
    private static final String CSV = ".csv";
    private static final String CSV_SEPARATOR = ",";
    private static final String[] CSV_HEADER = {"_id", "name", "type", "latitude", "longitude"};

    /**
     * This method is responsible for Write data into file
     *
     * @param file          File
     * @param locationArray DetailedLocation
     */
    public void writeToCSV(File file, GoEuroLocation[] locationArray) {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "UTF-8"));
            bw.write(StringUtils.join(CSV_HEADER, CSV_SEPARATOR));
            bw.newLine();
            for (GoEuroLocation location : locationArray) {
                StringBuffer oneLine = new StringBuffer();
                oneLine.append(STR);
                oneLine.append(location.get_id());
                oneLine.append(STR);
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(STR);
                oneLine.append(location.getName());
                oneLine.append(STR);
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(STR);
                oneLine.append(location.getType());
                oneLine.append(STR);
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(STR);
                oneLine.append(location.getGeo_position().getLatitude());
                oneLine.append(STR);
                oneLine.append(CSV_SEPARATOR);
                oneLine.append(STR);
                oneLine.append(location.getGeo_position().getLongitude());
                oneLine.append(STR);
                bw.write(oneLine.toString());
                bw.newLine();
            }
            bw.flush();
            bw.close();
            System.out.println("File created SuccessFully,Location:" + file.getPath());
        } catch (UnsupportedEncodingException e) {
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }

    /**
     * This method is responsible for Creating File
     *
     * @param cityName Name of City
     * @return File
     * @throws IOException
     */
    public File createFile(final String cityName) throws IOException {
        String str = System.getProperty("user.home");
        String folderName = str + FOLDER + FOLDER_SEPERATOR + cityName + CSV;
        File file = new File(folderName);
        if (file.exists()) {
            FileUtils.forceDelete(file);
        }
        FileUtils.forceMkdir(file.getParentFile());
        file.createNewFile();
        return file;
    }
}
