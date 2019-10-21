import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * 描述:<p></p>
 *
 * @author sheng.qian01@ucarinc.com
 * @version V1.0
 * @date 2019/10/9 9:25
 */
public class app {


	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocate(44444);
		buffer.put("afasf".getBytes());
		buffer.flip();
	}
}
