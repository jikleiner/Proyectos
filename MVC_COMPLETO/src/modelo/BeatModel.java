package modelo;

import java.util.ArrayList;
import javax.sound.midi.*;
import vista.BPMObserver;
import vista.BeatObserver;

public class BeatModel implements BeatModelInterface, MetaEventListener {

	// beats por minuto
	private int bpm = 90;

	// atributos para la configuración de MIDI
	private Sequencer sequencer;
	private Sequence sequence;
	private Track track;

	// 
	private ArrayList beatObservers = new ArrayList();
	private ArrayList bpmObservers = new ArrayList();
	

	// Método para registrar un BeatObserver
	public void registrarObserver(BeatObserver o) {
		beatObservers.add(o);
	}
	
	// Método para remover un BeatObserver
	public void removerObserver(BeatObserver o) {
		int i = beatObservers.indexOf(o);
		if (i >= 0) {
			beatObservers.remove(i);
		}
	}

	// Método para notificar a los BeatObserver
	public void notificarBeatObservers() {
		//
		for (int i = 0; i < beatObservers.size(); i++) {
			BeatObserver observer = (BeatObserver) beatObservers.get(i);
			observer.actualizarBeat();
		}
	}

	// Método para registrar un BPMObserver
	public void registrarObserver(BPMObserver o) {
		bpmObservers.add(o);
	}
	
	// Método para remover un BPMObserver
	public void removerObserver(BPMObserver o) {
		int i = bpmObservers.indexOf(o);
		if (i >= 0) {
			bpmObservers.remove(i);
		}
	}

	// Método para notificar a los BPMObserver
	public void notificarBPMObservers() {
		//
		for (int i = 0; i < bpmObservers.size(); i++) {
			BPMObserver observer = (BPMObserver) bpmObservers.get(i);
			observer.actualizarBPM();
		}
	}
	
	public void inicializar() {
		configurarMidi();
		buildTrackAndStart();
	}
	
	public void on() {
		sequencer.start();
		setBPM(90);
	}
	
	public void off() {
		sequencer.stop();
		setBPM(0);
	}
	
	public void setBPM(int bpm) {
		this.bpm = bpm;
		sequencer.setTempoInBPM(getBPM());
		notificarBPMObservers(); //
	}
	
	public int getBPM() {
		return bpm;
	}
	
	private void beatEvent() {
		notificarBeatObservers(); //
	}
	
	/* Configuración MIDI - inicio */
	// Método para capturar eventos MIDI
	public void meta(MetaMessage message) {
		if (message.getType() == 47) {
			beatEvent();
			sequencer.setTickPosition(0);
			setBPM(getBPM());
			sequencer.start();
		}
	}

	public void configurarMidi() {
		try {
			sequencer = MidiSystem.getSequencer();
			sequencer.open();
			sequencer.addMetaEventListener(this);
			sequence = new Sequence(Sequence.PPQ, 4);
			track = sequence.createTrack();
			sequencer.setTempoInBPM(getBPM());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void buildTrackAndStart() {
		int[] trackList = { 35, 0, 46, 0 };

		sequence.deleteTrack(null);
		track = sequence.createTrack();

		makeTracks(trackList);
		track.add(makeEvent(192, 9, 1, 0, 4));
		try {
			sequencer.setSequence(sequence);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void makeTracks(int[] list) {

		for (int i = 0; i < list.length; i++) {
			int key = list[i];

			if (key != 0) {
				track.add(makeEvent(144, 9, key, 100, i));
				track.add(makeEvent(128, 9, key, 100, i + 1));
			}
		}
	}

	public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
		MidiEvent event = null;
		try {
			ShortMessage a = new ShortMessage();
			a.setMessage(comd, chan, one, two);
			event = new MidiEvent(a, tick);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return event;
	}
	/* Configuración MIDI - fin */
}
