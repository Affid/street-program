package org.atrem.street.jsonParser;

import org.atrem.street.entities.Human;
import org.atrem.street.entities.Pet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface Parser<T>{
    T getObjFromJsonObj(String map);

    List<T> getArrayFromJsonArray(String jsonArr);

    default ArrayList<HashMap<String, String>> getMapArrayFromJsonArr(String arg){
        ArrayList<HashMap<String, String>> hashMapsArray = new ArrayList<>();
        StringBuilder map = new StringBuilder();

        int state = 0;

        for(int i = 0; i < arg.length(); i++){
            char element = arg.charAt(i);


            switch (state){
                case 0:
                    if(element == '{')
                        state = 1;
                    break;

                case 1:
                    if (element == '}'){
                        state = 2;
                        break;
                    }
                    map.append(element);
                    break;

                case 2:
                    hashMapsArray.add(getMapFromJsonObj(getClearJsonObj(map.toString())));
                    map.setLength(0);
                    state = 0;
                    break;
            }
        }
        return hashMapsArray;
    }

    default HashMap<String, String> getMapFromJsonObj(String arg){
        HashMap<String, String> map = new HashMap<>();

        StringBuilder key = new StringBuilder();
        StringBuilder value = new StringBuilder();

        int state = 0;
        boolean isSquareBrackets = false;

        for (int i =  0; i < arg.length(); i++){
            char element =  arg.charAt(i);

            if(element == ':'){
                state = 1;
            }
            else if(element == ']'){
                isSquareBrackets = false;
            }
            else if(element == '['){
                isSquareBrackets = true;
            }
            else if((element == ',' || i == arg.length() - 1) && !isSquareBrackets){
                state = 2;
            }

            switch (state){
                case 0:
                    if (!(element == '{' || element == '"'))
                        key.append(element);
                    break;

                case 1:
                    if(isSquareBrackets)
                        value.append(element);
                    else if (!(element == ':' || element == '"'))
                        value.append(element);
                    break;

                case 2:
                    if(i == arg.length() - 1 && !(element == '}'))
                        value.append(element);
                    map.put(key.toString().strip(), value.toString().strip());
                    key.delete(0, key.length());
                    value.delete(0, value.length());
                    state = 0;
                    break;
            }
        }
        return map;
    }

    default String getClearJsonObj(String arg){
        StringBuilder jsonObj = new StringBuilder(arg);
        for (int i = 0; i < jsonObj.length(); i++){
            char element = jsonObj.charAt(i);
            if(element == '{' || element == '}' || element == '"'){
                jsonObj.deleteCharAt(i);
                i = -1;
            }
        }
        return jsonObj.toString();
    }
}
