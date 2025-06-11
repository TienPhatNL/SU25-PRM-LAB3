package com.example.lab3_bai2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listViewLegends);

        List<FootballLegend> legends = new ArrayList<>();
        legends.add(new FootballLegend("Lê Minh Gia Mẫn", "Con rơi của Mendes (Tuổi 17)", R.drawable.le_minh_gia_man, R.drawable.ic_spain_flag));
        legends.add(new FootballLegend("Sa Tị", "Người hùng Chile (Tuổi 37)", R.drawable.sa_ti, R.drawable.ic_argentina_flag));
        legends.add(new FootballLegend("Kim Ree Đô", "Người hùng Hàn Quốc (Tuổi 40)", R.drawable.ro_nan_do, R.drawable.ic_portugal_flag));

        FootballLegendAdapter adapter = new FootballLegendAdapter(this, R.layout.list_item_legend, legends);
        listView.setAdapter(adapter);
    }
}