package net.yrom.screenrecorder.pdf;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.github.barteksc.pdfviewer.PDFView;

import net.yrom.screenrecorder.R;

import org.greenrobot.eventbus.EventBus;

import java.io.File;


public class PdfViewActivity extends Activity {
    PDFView pdfView;
    FloatingActionsMenu menuMultipleActions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf_view);
        init();
    }

    public void init(){
        pdfView = findViewById(R.id.pdfView);
        File file = new File( "/sdcard/test.pdf");
        pdfView.fromFile(file).swipeHorizontal(true)
                .pageSnap(true)
                .autoSpacing(true)
                .pageFling(true).load();
        initButton();
    }

    private void initButton(){
        FloatingActionButton actionA = findViewById(R.id.action_a);
        actionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(PdfViewActivity.this,"停止录制咯",Toast.LENGTH_LONG).show();
                EventBus.getDefault().post(new MessageEvent(1));
                menuMultipleActions.collapse();
                finish();
            }
        });
        FloatingActionButton actionB = findViewById(R.id.action_b);
        actionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuMultipleActions.collapse();
                Toast.makeText(PdfViewActivity.this,"可以标绘咯",Toast.LENGTH_LONG).show();
            }
        });
        menuMultipleActions = (FloatingActionsMenu) findViewById(R.id.multiple_actions);

    }
}
