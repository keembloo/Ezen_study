package java1.day18.Ex1;

public class Audio implements RemoteControl {
	
	// 필드
	private int volume; // 인스턴스 필드
	
	@Override
	public void turnOn() {
		System.out.println("Audio를 켭니다");
	}
	
	@Override
	public void turnOff() {
		System.out.println("Audio를 끕니다.");
	}
	
	@Override
	public void setVolume(int volume) {
		if(volume>RemoteControl.MAX_VOLUEM) {
			// 만약에 볼륨이 최대볼륨보다 크면
			this.volume = RemoteControl.MAX_VOLUEM; // this : 해당메소드를 호출한 객체 뜻
			// 해당 객체는 최대볼륨으로 대입
		} else if (volume < RemoteControl.MIN_VOLUEM) {
			// 만약에 볼륨이 최소볼륨보다 작으면
			this.volume = RemoteControl.MIN_VOLUEM;
			// 해당 객체의 소움을 최소볼륨으로 대입/설정
		} else {
			this.volume = volume;
		}
		System.out.println("현재 오디오 소음 : "+this.volume);
	}
}
