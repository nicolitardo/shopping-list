package com.example.group2.shoppinglist.Utility;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class ShoppingList implements Serializable {
    private String mShoppingListText;
    private boolean mHasReminder;
    private String mShoppingListDescription;
    private int mShoppinglistColor;
    private Date mShoppingListDate;
    private UUID mShoppinglistIdentifier;
    private ArrayList<ToDoItem> toDoItems;
    private static final String SHOPPINGLISTDESCRIPTION = "shoppinglistdescription";
    private static final String SHOPPINGLISTTEXT = "shoppinglisttext";
    private static final String SHOPPINGLISTREMINDER = "shoppinglistreminder";
    private static final String SHOPPINGLISTCOLOR = "shoppinglistcolor";
    private static final String SHOPPINGLISTDATE = "shoppinglistdate";
    private static final String SHOPPINGLISTIDENTIFIER = "shoppinglistidentifier";


    public ShoppingList(String shoppinglistBody, String shoppinglistdescription, boolean hasReminder, Date toDoDate) {
        mShoppingListText = shoppinglistBody;
        mHasReminder = hasReminder;
        mShoppingListDate = toDoDate;
        mShoppingListDescription = shoppinglistdescription;
        mShoppinglistColor = 1677725;
        mShoppinglistIdentifier = UUID.randomUUID();
    }

    public ShoppingList(JSONObject jsonObject) throws JSONException {
        mShoppingListText = jsonObject.getString(SHOPPINGLISTTEXT);
        mShoppingListDescription = jsonObject.getString(SHOPPINGLISTDESCRIPTION);
        mHasReminder = jsonObject.getBoolean(SHOPPINGLISTREMINDER);
        mShoppinglistColor = jsonObject.getInt(SHOPPINGLISTCOLOR);

        mShoppinglistIdentifier = UUID.fromString(jsonObject.getString(SHOPPINGLISTIDENTIFIER));

        if (jsonObject.has(SHOPPINGLISTDATE)) {
            mShoppingListDate = new Date(jsonObject.getLong(SHOPPINGLISTDATE));
        }
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(SHOPPINGLISTTEXT, mShoppingListText);
        jsonObject.put(SHOPPINGLISTREMINDER, mHasReminder);
        jsonObject.put(SHOPPINGLISTDESCRIPTION, mShoppingListDescription);
        if (mShoppingListDate != null) {
            jsonObject.put(SHOPPINGLISTDATE, mShoppingListDate.getTime());
        }
        jsonObject.put(SHOPPINGLISTCOLOR, mShoppinglistColor);
        jsonObject.put(SHOPPINGLISTIDENTIFIER, mShoppinglistIdentifier.toString());

        return jsonObject;
    }

    public String getmShoppingListDescription() { return mShoppingListDescription;}

    public void setmShoppingListDescription(String mShoppingListDescription){this.mShoppingListDescription = mShoppingListDescription;}

    public String getShoppingListText() {
        return mShoppingListText;
    }

    public void setShoppingListText(String mShoppingListText) {
        this.mShoppingListText = mShoppingListText;
    }

    public void setToDoItems(ArrayList<ToDoItem> items) {
        this.toDoItems = items;
    }

    public ArrayList<ToDoItem> getToDoItems() {
        return this.toDoItems;
    }

    public boolean hasReminder() {
        return mHasReminder;
    }

    public Date getShoppingListDate() {
        return mShoppingListDate;
    }

    public int getShoppinglistColor() {
        return mShoppinglistColor;
    }

    public void setShoppinglistColor(int mShoppinglistColor) {
        this.mShoppinglistColor = mShoppinglistColor;
    }

    public UUID getIdentifier() {
        return mShoppinglistIdentifier;
    }
}

