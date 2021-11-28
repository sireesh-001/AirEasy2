package com.cuberto.AirEasy;

import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.cuberto.AirEasy.ModelClass.profileModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import de.hdodenhof.circleimageview.CircleImageView;

public class profile extends AppCompatActivity {

    ImageView backImg;
    OutputStream outputStream;
    public CircleImageView imageView;
    StorageReference storageReference;
    FirebaseStorage storage;
    private Uri filePath;
    private final int PICK_IMAGE_REQUEST = 22;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
String logged=getIntent().getStringExtra("logged");
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        storage=FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        DatabaseReference databaseReference=firebaseDatabase.getReference("login").child("users").child(logged).child("Profile_info");
        Button button2=findViewById(R.id.change);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
Intent intent=new Intent(profile.this,change_email.class);
intent.putExtra("logged",logged);
startActivity(intent);
            }
        });
        Button button4=findViewById(R.id.logout);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             triggerRebirth(profile.this);
            }
        });
        backImg = findViewById(R.id.backImg);
        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });
        TextView textView=findViewById(R.id.tvReset);
        EditText editText=findViewById(R.id.nam);
        EditText editText1=findViewById(R.id.em);
        EditText editText2=findViewById(R.id.phno);
        EditText editText3=findViewById(R.id.passno);
        EditText editText4=findViewById(R.id.place);
        EditText editText5=findViewById(R.id.state);
        EditText editText6=findViewById(R.id.nation);
        EditText editText7=findViewById(R.id.zip);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
profileModel model=new profileModel(editText.getText().toString(),editText1.getText().toString(),editText2.getText().toString()
        ,editText4.getText().toString(),editText3.getText().toString(),editText5.getText().toString(),editText6.getText().toString()
        ,editText7.getText().toString());
databaseReference.push().setValue(model);
                Toast.makeText(profile.this, " Saved Please go back" ,Toast.LENGTH_SHORT).show();
            }
        });
        imageView=findViewById(R.id.profile);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setType("image/*");
//                intent.setAction(Intent.ACTION_GET_CONTENT);
//                startActivityForResult(
//                        Intent.createChooser(
//                                intent,
//                                "Select Image from here..."),
//                        PICK_IMAGE_REQUEST);
                startcamera();
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==999&& resultCode == RESULT_OK){
//            filePath=data.getData();
//            try {
//
//                // Setting image on image view using Bitmap
//                Bitmap bitmap = MediaStore
//                        .Images
//                        .Media
//                        .getBitmap(
//                                getContentResolver(),
//                                filePath);
//                imageView.setImageBitmap(bitmap);
//            }
//
//            catch (IOException e) {
//                // Log the exception
//                e.printStackTrace();
//            }
            Bundle bundle=data.getExtras();
            Bitmap bitmap=(Bitmap) bundle.get("data");
//            String path=saveToInternalStorage(bitmap);
//            loadImageFromStorage(path);
            imageView.setImageBitmap(bitmap);

//            File path= Environment.getExternalStorageDirectory();
//            File folder=new File(path.getAbsolutePath()+"/myapp");
//            folder.mkdir();


//            File [] folders = ContextCompat.getExternalFilesDirs(this, null);
//            File folder = new File(folders[0].getAbsolutePath()+"/apppics");
//            File folder=getApplicationContext().getExternalFilesDir("");
//            folder.mkdir();
//            File file=new File(folder,System.currentTimeMillis()+".jpg");
//            try {
//                outputStream= new FileOutputStream(file);
//            }
//            catch (FileNotFoundException e){
//                e.printStackTrace();
//            }
//            bitmap.compress(Bitmap.CompressFormat.JPEG,100,outputStream);
//            try{
//                outputStream.flush();
//            }
//            catch (IOException e){
//                e.printStackTrace();
//            }
//            try{
//                outputStream.close();
//            }
//            catch (IOException e){
//                e.printStackTrace();
//            }

        }
    }
//    private void loadImageFromStorage(String path)
//    {
//
//        try {
//            File f=new File(path, "profile.jpg");
//            Bitmap b = BitmapFactory.decodeStream(new FileInputStream(f));
////            ImageView img=(ImageView)findViewById(R.id.imgPicker);
//            imageView.setImageBitmap(b);
//        }
//        catch (FileNotFoundException e)
//        {
//            e.printStackTrace();
//        }
//
//    }
//    private String saveToInternalStorage(Bitmap bitmapImage){
//        ContextWrapper cw = new ContextWrapper(getApplicationContext());
//        // path to /data/data/yourapp/app_data/imageDir
//        File directory = cw.getDir("imageDir", Context.MODE_PRIVATE);
//        // Create imageDir
//        File mypath=new File(directory,"profile.jpg");
//
//        FileOutputStream fos = null;
//        try {
//            fos = new FileOutputStream(mypath);
//            // Use the compress method on the BitMap object to write image to the OutputStream
//            bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fos);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                fos.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        return directory.getAbsolutePath();
//    }
public static void triggerRebirth(Context context) {
    PackageManager packageManager = context.getPackageManager();
    Intent intent = packageManager.getLaunchIntentForPackage(context.getPackageName());
    ComponentName componentName = intent.getComponent();
    Intent mainIntent = Intent.makeRestartActivityTask(componentName);
    context.startActivity(mainIntent);
    Runtime.getRuntime().exit(0);
}
    public void startcamera(){

//        if (filePath != null) {
//        StorageReference ref
//                = storageReference
//                .child(
//                        "images/"
//                                + UUID.randomUUID().toString());
//        ref.putFile(filePath)
//                .addOnSuccessListener(
//                        new OnSuccessListener<UploadTask.TaskSnapshot>() {
//
//                            @Override
//                            public void onSuccess(
//                                    UploadTask.TaskSnapshot taskSnapshot)
//                            {
//
//
//                                Toast
//                                        .makeText(profile.this,
//                                                "Image Uploaded!!",
//                                                Toast.LENGTH_SHORT)
//                                        .show();
//                            }
//                        })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e)
//                    {
//
//                        Toast
//                                .makeText(profile.this,
//                                        "Failed " + e.getMessage(),
//                                        Toast.LENGTH_SHORT)
//                                .show();
//                    }
//                })
//                .addOnProgressListener(
//                        new OnProgressListener<UploadTask.TaskSnapshot>() {
//
//                            // Progress Listener for loading
//                            // percentage on the dialog box
//                            @Override
//                            public void onProgress(
//                                    UploadTask.TaskSnapshot taskSnapshot)
//                            {
//                                double progress
//                                        = (100.0
//                                        * taskSnapshot.getBytesTransferred()
//                                        / taskSnapshot.getTotalByteCount());
//                                Toast
//                                        .makeText(profile.this,
//                                                "Processing" + (int)progress,
//                                                Toast.LENGTH_SHORT)
//                                        .show();
//                            }
//                        });
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,999);
    }

}
