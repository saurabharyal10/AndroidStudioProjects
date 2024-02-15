package com.example.androidfinalproject;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class PostFragment extends Fragment {
    private View mainView;
//
//    private ImageView imgPhoto;
//    private Button btnUploadImage;
//    private Uri picUri;
//    private String currentImagePath;
//    private Bitmap bitmap;
//    private String type = "";
//
//    private Dialog originalDialog;
//    private AlertDialog.Builder alertDialogBuilder;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainView = inflater.inflate(R.layout.fragment_post, container, false);
//        findViews();
        return mainView;
    }


//    private void findViews() {
//        imgPhoto = mainView.findViewById(R.id.imgPhoto);
//        btnUploadImage = mainView.findViewById(R.id.btnImageUpload);
//        btnUploadImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                selectImage();
//            }
//        });
//
//    }
//
//    private void selectImage() {
//        alertDialogBuilder = new AlertDialog.Builder(this);
//        View dialogView = View.inflate(this, R.layout.upload_photo, null);
//        TextView txtTakePhoto = dialogView.findViewById(R.id.txtTakePhoto);
//        TextView txtChooseGallery = dialogView.findViewById(R.id.txtChooseGallery);
//        TextView txtCancel = dialogView.findViewById(R.id.txtCancel);
//        alertDialogBuilder.setView(dialogView);
//        txtTakePhoto.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                type = "Camera";
//                originalDialog.dismiss();
//                openCamera();
//            }
//        });
//        txtChooseGallery.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                type = "Gallery";
//                originalDialog.dismiss();
//                openGallery();
//            }
//        });
//        originalDialog = alertDialogBuilder.create();
//        txtCancel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                originalDialog.dismiss();
//            }
//        });
//        originalDialog.getWindow().setDimAmount(0.7f);
//        originalDialog.setCanceledOnTouchOutside(true);
//        originalDialog.show();
//    }
//
//
//    private void checkImagePermission() {
//
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED || ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//            //   is not granted
//            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)) {
//                AlertDialog alertDialog = new AlertDialog.Builder(this, R.style.DialogTheme)
//                        .setTitle("Call Permission Needed")
//                        .setMessage("This app needs the Camera and external storage  permission permission , please accept to use camera & gallery functionality")
//                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                Intent intent = new Intent();
//                                intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
//                                Uri uri = Uri.fromParts("package", getPackageName(), null);
//                                intent.setData(uri);
//                                startActivity(intent);
//                            }
//                        })
//                        .create();
//                alertDialog.setCancelable(false);
//                alertDialog.show();
//            } else {
//                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
//            }
//        } else {
//            if (type == "Camera")
//                openCamera();
//            else
//                openGallery();
//        }
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        switch (requestCode) {
//            case 100:
//                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED && grantResults[2] == PackageManager.PERMISSION_GRANTED && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
//                    if (ActivityCompat.checkSelfPermission(this,
//                            Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
//                            Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
//                            Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
////                        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "9864831976"));
////                        startActivity(intent);
//                        if (type == "Camera")
//                            openCamera();
//                        else
//                            openGallery();
//                    }
//                } else {
//                    if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA) ||
//                            ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) ||
//                            ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
//
//                        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 100);
//                    } else {
//                        Intent intent = new Intent();
//                        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
//                        Uri uri = Uri.fromParts("package", getPackageName(), null);
//                        intent.setData(uri);
//                        startActivity(intent);
//                    }
//                }
//                break;
//        }
//
//
//    }
//
//    private void openGallery() {
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED &&
//                ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
//            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//            startActivityForResult(intent, 200);
//        } else {
//            checkImagePermission();
//        }
//    }
//
//    private void openCamera() {
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
//            Intent pictureIntent = new Intent(
//                    MediaStore.ACTION_IMAGE_CAPTURE);
//            if (pictureIntent.resolveActivity(getPackageManager()) != null) {
//                //Create a file to store the image
//                File photoFile = null;
//                try {
//                    photoFile = createImageFile();
//                } catch (IOException ex) {
//                }
//                if (photoFile != null) {
//                    String path = getPackageName() + ".fileprovider";
//                    Log.d("Path", path);
//                    picUri = FileProvider.getUriForFile(this, getPackageName() + ".fileprovider", photoFile);
//                    pictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
//                            picUri);
//                    startActivityForResult(pictureIntent,
//                            101);
//                }
//
//            }
//        } else {
//            checkImagePermission();
//
//        }
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 101) {
//            if (resultCode == RESULT_OK) {
//                File imgFile = new File(currentImagePath);
//                BitmapFactory.Options options = new BitmapFactory.Options();
//                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
//
//                Bitmap bitmap = null;
//                try {
//                    bitmap = BitmapFactory.decodeStream(new FileInputStream(imgFile), null, options);
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                }
//                imgPhoto.setImageBitmap(bitmap);
//            }
//        } else if (requestCode == 200) {
//            if (resultCode == RESULT_OK) {
//                if (data != null) {
//                    picUri = data.getData();
//                    try {
//                        bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), picUri);
//                        imgPhoto.setImageBitmap(bitmap);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            }
//
//        }
//    }
//
//    private File createImageFile() throws IOException {
//        // Create an image file name
//        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
//        File image = File.createTempFile(
//                "JPEG_" + timeStamp,
//                ".jpg",
//                storageDir
//        );
//
//        currentImagePath = image.getAbsolutePath();
//        return image;
//    }

}