package com.hfad.rough1connect4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.constraint.solver.widgets.Rectangle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import static android.widget.Toast.*;


public class CustomView extends View {

    private Paint mPaint;
    private Canvas mCanvas;
    private Bitmap newBitmap;
    private Rect mRect;
    private Bitmap mBitmap=null;
    private int BackgroundColor;
    private int BoardColor;
    private float CellWidth;
    private float CellHeigth;
    private float mWidth;
    private float mHeigth;
    private Paint kPaint;
    private int HoleColor;
    private Paint dPaint;
    private int DiscColor;
    public int count=0;
    private int[][] a =new int[7][6];

    public CustomView(Context context) {
        super(context);
        init();
    }

    public CustomView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        BoardColor = Color.parseColor("#229ED6");
        mPaint.setColor(BoardColor);
        mPaint.setStyle(Paint.Style.FILL);
        BackgroundColor = Color.parseColor("#202641");
        kPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        HoleColor=Color.parseColor("#E1F1D0");
        kPaint.setColor(HoleColor);
        kPaint.setStyle(Paint.Style.FILL);
        mRect = new Rect();
        dPaint= new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onSizeChanged(int mWidth, int mHeigth, int oldw, int oldh) {
        this.mWidth = mWidth;
        this.mHeigth = mHeigth;
        CellWidth = mWidth/9;
        CellHeigth = mHeigth/12;
        super.onSizeChanged(mWidth, mHeigth, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas mCanvas) {
        super.onDraw(mCanvas);
        if(mBitmap==null)
        {
            mBitmap = Bitmap.createBitmap((int)mWidth, (int)mHeigth, Bitmap.Config.ARGB_8888);
            mCanvas=new Canvas(mBitmap);
        }
        mCanvas.drawColor(BackgroundColor);
        drawBoard(mCanvas);

    }

    public void drawBoard(Canvas mCanvas)
    {   mRect.set((int)(1*CellWidth),(int)(3*CellHeigth),(int) (8*CellWidth), (int)(9*CellHeigth));         // Board
        mCanvas.drawRect(mRect, mPaint);
        for (int i = 0; i < 7; i++)
            for (int j = 0; j < 6; j++) {
                mCanvas.drawCircle(CellWidth / 2 + (i + 1) * CellWidth, (3 * CellHeigth) + (j) * CellHeigth + CellWidth / 2, CellWidth / 2, kPaint);
                a[i][j] = 0;
            }

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_DOWN)
        {
            float x = event.getX();
            float y = event.getY();

            count++;
            DropBead(x,y,count);
        }

        return true;
    }

    public void DropBead(float x,float y , int count)
    {
        if((count%2)==0)
            DiscColor = Color.parseColor("#D60E52");
        else
            DiscColor = Color.parseColor("#FFEB3B");                // Setting DISC COLOR
        dPaint.setColor(DiscColor);

        if((x>CellWidth)&&(x<2*CellWidth))
        {   int i=0;
            mCanvas.drawRect(CellWidth,3*CellHeigth,2*CellWidth,9*CellHeigth,dPaint);

        }


        else if(x>2*CellWidth&&x<3*CellWidth)
        {   int i=1;
            for(int j=5;j>=0;j--) {
                if (!(a[i][j] == 0)) {
                    if (!(j == 5))
                        a[i][j + 1] = count;
                    mCanvas.drawCircle(CellWidth*(i+3/2),CellWidth/2+CellHeigth*(4+j),CellWidth/2,dPaint);
                }

                if (a[i][0] == 0)
                {a[i][0] = count;
                    mCanvas.drawCircle(CellWidth*(i+3/2),9*CellHeigth+CellWidth/2,CellWidth/2,dPaint);}
            }

        }
        else if(x>3*CellWidth&&x<4*CellWidth)
        {   int i=2;
            for(int j=5;j>=0;j--) {
                if (!(a[i][j] == 0)) {
                    if (!(j == 5))
                        a[i][j + 1] = count;
                    mCanvas.drawCircle(CellWidth*(i+3/2),CellWidth/2+CellHeigth*(4+j),CellWidth/2,dPaint);
                }

                if (a[i][0] == 0)
                {a[i][0] = count;
                    mCanvas.drawCircle(CellWidth*(i+3/2),9*CellHeigth+CellWidth/2,CellWidth/2,dPaint);}
            }

        }
        else if(x>4*CellWidth&&x<5*CellWidth)
        {   int i=3;
            for(int j=5;j>=0;j--) {
                if (!(a[i][j] == 0)) {
                    if (!(j == 5))
                        a[i][j + 1] = count;
                    mCanvas.drawCircle(CellWidth*(i+3/2),CellWidth/2+CellHeigth*(4+j),CellWidth/2,dPaint);
                }

                if (a[i][0] == 0)
                {a[i][0] = count;
                    mCanvas.drawCircle(CellWidth*(i+3/2),9*CellHeigth+CellWidth/2,CellWidth/2,dPaint);}
            }

        }
        else if(x>5*CellWidth&&x<6*CellWidth)
        {   int i=4;
            for(int j=5;j>=0;j--) {
                if (!(a[i][j] == 0)) {
                    if (!(j == 5))
                        a[i][j + 1] = count;
                    mCanvas.drawCircle(CellWidth*(i+3/2),CellWidth/2+CellHeigth*(4+j),CellWidth/2,dPaint);
                }

                if (a[i][0] == 0)
                {a[i][0] = count;
                    mCanvas.drawCircle(CellWidth*(i+3/2),9*CellHeigth+CellWidth/2,CellWidth/2,dPaint);}
            }

        }
        else if(x>6*CellWidth&&x<7*CellWidth)
        {   int i=5;
            for(int j=5;j>=0;j--) {
                if (!(a[i][j] == 0)) {
                    if (!(j == 5))
                        a[i][j + 1] = count;
                    mCanvas.drawCircle(CellWidth*(i+3/2),CellWidth/2+CellHeigth*(4+j),CellWidth/2,dPaint);
                }

                if (a[i][0] == 0)
                {a[i][0] = count;
                    mCanvas.drawCircle(CellWidth*(i+3/2),9*CellHeigth+CellWidth/2,CellWidth/2,dPaint);}
            }

        }
        else if(x>7*CellWidth&&x<8*CellWidth)
        {   int i=6;
            for(int j=5;j>=0;j--) {
                if (!(a[i][j] == 0)) {
                    if (!(j == 5))
                        a[i][j + 1] = count;
                    mCanvas.drawCircle(CellWidth*(i+3/2),CellWidth/2+CellHeigth*(4+j),CellWidth/2,dPaint);
                }

                if (a[i][0] == 0)
                {a[i][0] = count;
                    mCanvas.drawCircle(CellWidth*(i+3/2),9*CellHeigth+CellWidth/2,CellWidth/2,dPaint);}
            }

        }

    }
}

