import java.util.*;
import java.nio.*;

public class TransformTest3 {
	public static void main(String[] args) {
     int[] src = {10,20,30,40};
     int[] dst;
     System.out.println(Arrays.toString(src));
     ByteBuffer bBuffer;
     IntBuffer isrcBuffer, idstBuffer;
     
     isrcBuffer = IntBuffer.wrap(src);  // int->Int
     bBuffer = ByteBuffer.allocate(isrcBuffer.capacity()*4);
     
     for(int i=0;i<isrcBuffer.capacity();i++) {
    	 bBuffer.putInt(isrcBuffer.get(i));    // Int->Byte
     }
     bBuffer.flip();
     idstBuffer = bBuffer.asIntBuffer();    // Byte->Int
     dst = new int[idstBuffer.capacity()];
     
     for(int i=0;i<dst.length;i++) {
	     dst[i] = idstBuffer.get();    // Int->int       
     }
     System.out.println(Arrays.toString(dst)); // int->Sting
  }
}  // int->Int->Byte->Int->int


import java.util.*;
import java.nio.*;
import java.nio.charset.*;

public class TransformTest2 {
	public static void main(String[] args) {
	 String[] data = {"안녕","나는민이라고해","친하게지내자"};
	 
	 Charset cs = Charset.defaultCharset();
	 ByteBuffer buffer = ByteBuffer.allocate(1024*1024);
	 for(int i=0;i<data.length;i++) {
		 ByteBuffer tmp = cs.encode(data[i]); //String->Byte (encode)
		 buffer = buffer.put(tmp);   // buffer에 tmp 저장(둘 다 Byte버퍼)
}
byte[] b_total = new byte[buffer.flip().limit()]; //flip 상태에서 limit의 값만큼 b_total에 바이트 타입 할당
int index = 0;
while(buffer.position()<buffer.limit()) {
	byte b = buffer.get();
	Arrays.fill(b_total,index,index+1,b); //b_total 배열에 인덱스 한 칸씩 b데이터를 저장한다.
	index++;
}
StringBuffer sb = new StringBuffer();
sb.append(cs.decode(ByteBuffer.wrap(b_total))); // Byte->String (decode)
System.out.println(sb);
	}
}
