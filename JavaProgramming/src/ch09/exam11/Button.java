package ch09.exam11;

//이벤트 처리 패턴
public class Button {
	
	//중첩 인터페이스
	public static interface OnClickListener{
		void onClick();
	}
	
	//인터페이스 타입의 필드 선언
	private OnClickListener onClickListener;
	public void setOnClickListener(OnClickListener onClickListener) {
		this.onClickListener = onClickListener;
	}


	public void click(){
		if(onClickListener != null){
			onClickListener.onClick();
		}		
	}
}
