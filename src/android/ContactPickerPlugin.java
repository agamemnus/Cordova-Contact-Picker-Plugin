package com.flyingsoftgames.contactpickerplugin;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONObject;

public class ContactPickerPlugin extends CordovaPlugin {
 private CallbackContext tryConnectCallback = null;
 private static final int REQUEST_SELECT_EMAIL = 1001;
 
 private void doSetResultCallBack () {
  cordova.setActivityResultCallback (this);
 }
 
 @Override public boolean execute (String action, JSONArray data, CallbackContext callbackContext) {
  if (action.equals("pickContact")) {
   Intent intent = new Intent (Intent.ACTION_PICK);
   intent.setType(ContactsContract.CommonDataKinds.Email.CONTENT_TYPE);
   doSetResultCallBack ();
   cordova.getActivity().startActivityForResult (intent, REQUEST_SELECT_EMAIL);
   tryConnectCallback = callbackContext;
  }
  return true;
 }
 
 public void onActivityResult (int requestCode, int resultCode, Intent data) {
  if (requestCode != REQUEST_SELECT_EMAIL || resultCode != Activity.RESULT_OK) return;
  // Get the URI and query the content provider for the email.
  Uri contactUri = data.getData();
  String[] projection = new String[]{ContactsContract.CommonDataKinds.Email.DATA};
  Cursor cursor = cordova.getActivity().getApplicationContext().getContentResolver().query(contactUri, projection, null, null, null);
  // If the cursor returned is valid, get the email.
  if ((cursor == null) || (!cursor.moveToFirst())) {cursor.close(); return;}
  
  int index = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA);
  String email = cursor.getString(index);
  
  if (tryConnectCallback == null) return;
  try {
   JSONObject contact = new JSONObject();
   contact.put("email", email);
   tryConnectCallback.success (contact);
   tryConnectCallback = null;
  } catch (Exception e) {
   tryConnectCallback.error("Parsing contact failed: " + e.getMessage());
  }
 }
}
