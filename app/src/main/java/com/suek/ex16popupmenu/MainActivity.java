package com.suek.ex16popupmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // 2)
    Button btn;
    Button btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 3)
        btn= findViewById(R.id.btn);
        btn2= findViewById(R.id.btn2);

        // id를 찾고 버튼에 롱~~클릭 리스너 객체 생성 및 설정!!
        btn.setOnLongClickListener(new View.OnLongClickListener() {    //익명 클래스
            @Override
            public boolean onLongClick(View v) {
                //Toast.makeText(MainActivity.this, "Long Click", Toast.LENGTH_SHORT).show();


                // 5) PopupMenu 객체생성 [Menu 객체가 놓여질 수 있는 양탄자 같은 객체]
                PopupMenu popup= new PopupMenu(MainActivity.this, btn2);  //두번째 파라미터가 팝업메뉴가 붙을 뷰
                MenuInflater menuInflater= getMenuInflater();
                menuInflater.inflate(R.menu.popup, popup.getMenu());


                // 7) 팝업메뉴의 메뉴아이템을 클릭했을때 듣는 리스너 객체 생성 및 설정
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {

                        int id= item.getItemId();
                        switch (id){
                            case R.id.menu_info:
                                Toast.makeText(MainActivity.this, "INFORMATION TOAST", Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.menu_delete:
                                Toast.makeText(MainActivity.this, "DELETE TOAST", Toast.LENGTH_SHORT).show();
                                break;

                            case R.id.menu_modify:
                                Toast.makeText(MainActivity.this, "MODIFY TOAST", Toast.LENGTH_SHORT).show();
                            break;
                        }

                        return false;
                    }
                });

                // 6) 팝업메뉴 보이기
                popup.show();


               // 4)
                //리턴값: 이 클릭 이벤트의 작업을 여기서 마칠 것 인지에 대한 여부
                //return false;   //이렇게하면 여기서 안끝나고 click 이 또나옴
                return true;      //consumed(소비되었다)
            }
        });
    }


    // 1)
    public void clickBtn(View view) {
        Toast.makeText(this, "Click", Toast.LENGTH_SHORT).show();
    }
}
