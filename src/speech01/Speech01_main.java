package speech01;

import java.io.File;
import java.io.InputStream;

import com.ibm.watson.developer_cloud.text_to_speech.v1.TextToSpeech;
import com.ibm.watson.developer_cloud.text_to_speech.v1.model.SynthesizeOptions;
import com.ibm.watson.developer_cloud.text_to_speech.v1.util.WaveUtils;

public class Speech01_main {
	public static void main(String[] args){
		TextToSpeech synthesizer = new TextToSpeech();
		   synthesizer.setUsernameAndPassword("2344d01a-fb88-4425-b7da-18244248b4c5", "xAJDkBPhDl2s");
		   String translation="今日は良い天気ですね";
		   SynthesizeOptions synthesizeOptions = new SynthesizeOptions.Builder()
			       .text(translation)
			       .voice(SynthesizeOptions.Voice.JA_JP_EMIVOICE)
			       .accept(SynthesizeOptions.Accept.AUDIO_WAV)
			       .build();
			   InputStream in = synthesizer.synthesize(synthesizeOptions).execute();
		   try {
			   writeToFile(WaveUtils.reWriteWaveHeader(in), new File("output.wav"));
		   } catch (Exception e) {
		     e.printStackTrace();
		   }
		 }

	private static void writeToFile(InputStream reWriteWaveHeader, File file) {
		// TODO Auto-generated method stub

	}



}
