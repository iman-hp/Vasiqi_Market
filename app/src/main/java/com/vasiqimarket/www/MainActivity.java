package com.vasiqimarket.www;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import java.util.ArrayList;
import java.lang.String;

    public class MainActivity extends AppCompatActivity implements BaseSliderView.OnSliderClickListener,ViewPagerEx.OnPageChangeListener{
    LinearLayout linearShoeAllProduct;
    ArrayList<String> urlPics;
    ArrayList<String> names;
    String drawverMenuList;
    ListView navigateListView;
    ImageView hambergurMenu;
    DrawerLayout drawerLayout;
    ListView productList;
    ListView SettingListView;
    ListView settingListView;
        TextView txtsign;


    ArrayList<bayMenuListItem> items ;
    ArrayList<productMenuListItem> productItem;
    ArrayList<SettingMenuListItem> settingItem;



 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menubar);
        urlPics=new ArrayList<>();
        names =new ArrayList<>();
        SliderLayout sliderShow = (SliderLayout) findViewById(R.id.slider);
        hambergurMenu=(ImageView)findViewById(R.id.hambergurMenu);
        drawerLayout=(DrawerLayout)findViewById(R.id.drawer);
        productList=(ListView)findViewById(R.id.productListView);
     SettingListView=(ListView)findViewById(R.id.settingListView) ;
     txtsign= (TextView) findViewById(R.id.txtsign);
     txtsign.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             Intent intent=new Intent(MainActivity.this,UserSign.class);
             startActivity(intent);
         }
     });

        items=new ArrayList<>();
        productItem=new ArrayList<>();
        settingItem=new ArrayList<>();

        items.add(new bayMenuListItem(R.drawable.blue_home,"خانه"));
        items.add(new bayMenuListItem(R.drawable.blue_menu,"لیست دسته بندی ها"));
        items.add(new bayMenuListItem(R.drawable.blue_basket,"خرید"));


        productItem.add(new productMenuListItem("پیشنهاد ویژه دیجی کالا"));
     productItem.add(new productMenuListItem("پرفروش ترین ها"));
     productItem.add(new productMenuListItem("جدیدترین ها"));
     productItem.add(new productMenuListItem("پر بازدید ترین ها"));


     settingItem.add(new SettingMenuListItem("تنظیمات"));
     settingItem.add(new SettingMenuListItem("سوال های متداول"));
     settingItem.add(new SettingMenuListItem("درباره ما"));





        navigateListView=(ListView)findViewById(R.id.navigaterlistView);
        navigateListView.setAdapter(new buymenuAdapter(MainActivity.this,R.layout.buy_menu_list,items));
        productList.setAdapter(new ProductMenuAdapter(MainActivity.this,R.layout.product_menu_list,productItem));
        SettingListView.setAdapter(new SettingMenuAdapter(MainActivity.this,R.layout.setting_menu_list,settingItem));




        hambergurMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(Gravity.RIGHT);
            }
        });
        urlPics.add("http://hyperyab.com/assets/images/product/zoom/5beb614053c24d4531188c484272facb.jpg");
        urlPics.add("http://www.shahrvand.ir/upload/product/6260916000141(1).jpg");
        urlPics.add("http://www.taniamall.ir/239-thickbox_default/%D8%B3%D8%B3-%D8%B3%D8%A7%D9%84%D8%A7%D8%AF-%DA%86%DB%8C%D9%84%DB%8C-450-%DA%AF%D8%B1%D9%85%DB%8C-%D8%AF%D9%84%D9%BE%D8%B0%DB%8C%D8%B1.jpg");
        urlPics.add("http://markiti.com//Opitures/113505830448730.JPG");

        names.add("محصولات");



        for(int i=0;i<urlPics.size();i++) {
            TextSliderView textsliderview = new TextSliderView(this);
            textsliderview.image(urlPics.get(i))
                    .setScaleType(BaseSliderView.ScaleType.Fit)
            .setOnSliderClickListener(this);

            textsliderview.bundle(new Bundle());
            textsliderview.getBundle()
                    .putStringArrayList("extra",names);





            sliderShow.addSlider(textsliderview);

        }
       // TextSliderView textSliderView = new TextSliderView(this);
      //  textSliderView
       //         .description("Game of Thrones")
       //         .image("http://images.boomsbeat.com/data/images/full/19640/game-of-thrones-season-4-jpg.jpg");

      //  sliderShow.addSlider(textSliderView);


        linearShoeAllProduct=(LinearLayout)findViewById(R.id.linearShoeAllProduct);
        linearShoeAllProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"clicked",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {
        Toast.makeText(MainActivity.this,slider.getBundle().get("extra") + "",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
