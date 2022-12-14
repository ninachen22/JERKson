package io.zipcoder;

import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;
import io.zipcoder.utils.match.MatchGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemParser {
    public List<Item> parseItemList(String valueToParse) {
        List<Item> list = new ArrayList<>();
        String[] items = valueToParse.split("##");
        System.out.println("items arr: " + Arrays.toString(items));
        for (String s : items) {
            try {
                list.add(parseSingleItem(s));
                System.out.println("current list: " + list);
            } catch (Exception e) {
//                throw new RuntimeException(e);
            }
        }
        System.out.println("list: " + list);
        return list;
    }

    public Item parseSingleItem(String singleItem) throws ItemParseException {
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(singleItem);
        MatchGroup mg = new MatchGroup(matcher);
//        while (matcher.find()) {
            try {
                Item item = new Item(
                        mg.get(1).getValue().toLowerCase(),
                        Double.parseDouble(mg.get(3).getValue() + "." + mg.get(4).getValue()),
                        mg.get(6).getValue().toLowerCase(),
                        mg.get(8).getValue() + "/" +
                                mg.get(9).getValue() + "/" +
                                mg.get(10).getValue()
                );
                System.out.println(item);
                return item;
            } catch (Exception e) {
                throw new ItemParseException();
            }
//        }

//        //works
//        String[] keyValuePairs = singleItem.split(";");
//        System.out.println("key value pairs arr: " + Arrays.toString(keyValuePairs));
//        String[] temp = new String[4];
//        int tempIndex = 0;
////        while (matcher.find()) {
//        for (String s : keyValuePairs) {
//            String[] keyValueSplit = s.split("[:@^%*]");
//            if (keyValueSplit.length == 1) {
//                throw new ItemParseException();
//            } else {
//                keyValueSplit[1] = keyValueSplit[1].toLowerCase();
//                System.out.println("key value split index[1]: " + keyValueSplit[1]);
//                temp[tempIndex] = keyValueSplit[1].replaceAll("#", "");
//                System.out.println("temp index: " + tempIndex);
//                tempIndex++;
//                System.out.println("-------------------------");
//            }
//        }
////        }
//        String name = temp[0];
//        Double price = Double.valueOf(temp[1]);
//        String type = temp[2];
//        String expiration = temp[3];
//        Item item = new Item(name, price, type, expiration);
//        System.out.println(item);
//        return item;
    }

    //to catch exception - not working yet - for above
//        String[] test = singleItem.split("");
//        Boolean contains = false;
//        int semiCount = 0;
//        for (String s : test){
//            if (Objects.equals(s, ";")) {
//                semiCount++;
//            }
//            if (semiCount == 3) {
//                contains = true;
//            }
//        }
//        if (!contains) {
//            throw new ItemParseException();
//        }
    //        if (!(keyValuePairs.length == 4)) {
//            throw new ItemParseException();
//        }
//        for (String s : keyValuePairs)
//                if (!s.contains(":")) {
//
//            }
//        }
//        String regexStr = "[:@^%*]";
//        Pattern pattern = Pattern.compile(regexStr);
//        Matcher matcher = pattern.matcher(singleItem);
}
