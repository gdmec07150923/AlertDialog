package com.example.administrator.alertdialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;





public class MainActivity extends AppCompatActivity {
    private AlertDialog dialog;
    private AlertDialog.Builder builder;
    ;

    ;
    private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=(TextView)this.findViewById(R.id.textView1);
        Button btn=(Button) findViewById(R.id.button);
        Button btn2=(Button) findViewById(R.id.button2);
        Button btn3=(Button) findViewById(R.id.button3);
        Button btn4=(Button) findViewById(R.id.button4);
        Button btn5=(Button) findViewById(R.id.button5);
        Button btn6=(Button) findViewById(R.id.button6);
        Button btn7=(Button) findViewById(R.id.button7);
        View.OnClickListener listener=new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.button:
                        dialong1();
                        break;
                    case R.id.button2:
                        dialong2();
                        break;
                    case R.id.button3:
                        dialong3();
                        break;
                    case R.id.button4:
                        dialong4();
                        break;
                    case R.id.button5:
                        dialong5();
                        break;
                    case R.id.button6:
                        dialong6();
                        break;

                }
            }
        };
        btn.setOnClickListener(listener);
        btn2.setOnClickListener(listener);
        btn3.setOnClickListener(listener);
        btn4.setOnClickListener(listener);
        btn5.setOnClickListener(listener);
        btn6.setOnClickListener(listener);
        btn7.setOnClickListener(listener);
    }



    private void dialong1() {
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("两个按钮");
        dialog.setMessage("确定退出吗");
        dialog.setIcon(android.R.drawable.ic_dialog_alert);
        DialogInterface.OnClickListener listenter = new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (which == DialogInterface.BUTTON_POSITIVE) {
                    dialog.dismiss();
                    MainActivity.this.finish();
                } else if (which == DialogInterface.BUTTON_NEGATIVE) {
                    dialog.dismiss();
                }
            }
        };

        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"退出",listenter);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",listenter);
        dialog.show();
    }
    private void dialong2() {
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("调查");
        dialog.setMessage("你忙吗？");
        dialog.setIcon(android.R.drawable.ic_dialog_info);
        DialogInterface.OnClickListener listenter2=new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="";
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        str="杜甫很忙";
                        break;
                    case DialogInterface.BUTTON_NEGATIVE:
                        str="杜甫很闲";
                        break;
                    case DialogInterface.BUTTON_NEUTRAL:
                        str="杜甫无所谓在";
                        break;

                }
                tv1.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_POSITIVE,"很忙",listenter2);
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"很闲",listenter2);
        dialog.setButton(DialogInterface.BUTTON_NEUTRAL,"一般",listenter2);
        dialog.show();
    }
    private void dialong3() {
        dialog = new AlertDialog.Builder(this).create();
        dialog.setTitle("输入的");
        dialog.setMessage("请输入获奖感言");
        dialog.setIcon(android.R.drawable.ic_dialog_dialer);
        final EditText et1=new EditText(this);
        dialog.setView(et1);
        DialogInterface.OnClickListener listener3=new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tv1.setText("你的感言:"+et1.getText().toString());
            }
        };
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"确定",listener3);
        dialog.show();
    }
    private void dialong4() {
        final String item[]=new String[]{"北京","上海","广州"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnMultiChoiceClickListener lis4=new DialogInterface.OnMultiChoiceClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                bSelect[which]=isChecked;
            }
        };
        builder=new AlertDialog.Builder(this);
        builder.setMultiChoiceItems(item,bSelect,lis4);
        dialog=builder.create();
        dialog.setTitle("多选框");
        DialogInterface.OnClickListener lis41=new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选了";
                for(int i=0;i<bSelect.length;i++){
                    if(bSelect[i]){
                        str =str+"\n"+item[i];
                    }
                }
                tv1.setText(str);
            }
        };
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE,"确定",lis41);
        dialog.show();
    }
    private void dialong5() {
        final String item[]=new String[]{"北京","上海","广州"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnClickListener lis5=new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                for(int i=0;i<bSelect.length;i++){
                    if(i!=which){
                        bSelect[i]=false;
                    }else{
                        bSelect[i]=true;
                    }
                }
            }


        };
        builder=new AlertDialog.Builder(this);
        builder.setSingleChoiceItems(item,-1,lis5);
        dialog=builder.create();
        dialog.setTitle("单选框");
        DialogInterface.OnClickListener lis51=new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选了";
                for(int i=0;i<bSelect.length;i++){
                    if(bSelect[i]){
                        str =str+"\n"+item[i];
                    }
                }
                tv1.setText(str);
            }
        };
        dialog.setButton(AlertDialog.BUTTON_POSITIVE,"确定",lis51);
        dialog.show();
    }
    private void dialong6() {
        final String item[]=new String[]{"北京","上海","广州"};
        final boolean bSelect[]=new boolean[item.length];
        DialogInterface.OnClickListener lis6=new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str="你选择了："+item[which];
                tv1.setText(str);
            }
        };
        builder=new AlertDialog.Builder(this);
        builder.setItems(item,lis6);
        dialog=builder.create();
        dialog.setTitle("列表");
        DialogInterface.OnClickListener lis61=new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        };
        dialog.setButton(AlertDialog.BUTTON_POSITIVE,"确定",lis61);
        dialog.show();
    }






}
