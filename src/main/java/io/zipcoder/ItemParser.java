package io.zipcoder;

import io.zipcoder.utils.Item;
import io.zipcoder.utils.ItemParseException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ItemParser {
    public List<Item> parseItemList(String valueToParse) {
        List<Item> list = new ArrayList<>();
        String[] items = valueToParse.split("##");
        System.out.println("items arr: " + Arrays.toString(items));
        for (String s : items) {
            Item temp = null;
            try {
                temp = parseSingleItem(s);
            } catch (ItemParseException e) {
                throw new RuntimeException(e);
            }
            System.out.println("item being added to list: " + temp);
            list.add(temp);
        }
        System.out.println("list: " + list);
        return list;
//        return null;
    }

    public Item parseSingleItem(String singleItem) throws ItemParseException {
        String[] keyValuePairs = singleItem.split(";");
        String regexStr = "[/W]";
        Pattern pattern = Pattern.compile(regexStr);
        Matcher matcher = pattern.matcher(singleItem);
        System.out.println("key value pairs arr: " + Arrays.toString(keyValuePairs));
        String[] temp = new String[4];
        int tempIndex = 0;
//        while (matcher.find()) {
        for (String s : keyValuePairs) {
            String[] keyValueSplit = s.split("[:@^%]");
            keyValueSplit[1] = keyValueSplit[1].toLowerCase();
            System.out.println("key value split index[1]: " + keyValueSplit[1]);
            temp[tempIndex] = keyValueSplit[1].replaceAll("#", "");
            System.out.println("temp index: " + tempIndex);
            tempIndex++;
            System.out.println("-------------------------");
        }
//        }
        String name = temp[0];
        Double price = Double.valueOf(temp[1]);
        String type = temp[2];
        String expiration = temp[3];
        Item item = new Item(name, price, type, expiration);
        System.out.println(item);
        return item;
//        return null;
    }
}
