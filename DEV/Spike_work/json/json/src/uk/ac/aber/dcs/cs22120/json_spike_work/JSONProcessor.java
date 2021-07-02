package uk.ac.aber.dcs.cs22120.json_spike_work;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Class to process JSON files, including reading in, loading into the
 * program and saving to file, including any modifications.
 *
 * @author jor69
 * @version 1.0.1
 */

public class JSONProcessor {

    //Instance variables
    private ArrayList<Word> words;
    private ObjectMapper mapper;

    public JSONProcessor() {
        words = new ArrayList<>();
        mapper = new ObjectMapper();
    }

    public boolean read(String filename) {
        try {
            words = mapper.readValue(new File(filename), new TypeReference<ArrayList<Word>>(){});
        } catch(JsonParseException e) {
            e.printStackTrace();
            return false;
        } catch(JsonMappingException e) {
            e.printStackTrace();
            return false;
        } catch(IOException e) {
            return false;
        }

        return true;
    }

    public void write(String filename) {
        try {
            mapper.writeValue(new File(filename), words);
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Word> export() {
        return words;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int i = 0;

        for(Word word : words) {
            builder.append("\n>>>> Word ");
            builder.append(i);
            builder.append(word.toString());
            i++;
        }

        return builder.toString();
    }
}
