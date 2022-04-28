let array = [8, 5, 6, 2, 4];
let isChange = false;

for(let i=0; i<(array.length-1); i++){
	isChange = false;
	for(let j=i+1; j>0; j--){
		let key = j;
		if(array[key] < array[j-1]){
			let temp = array[key];
			array[key] = array[j-1];
			array[j-1] = temp;
			isChange = true;
		}
	}//inner-for
	if(!isChange) break; //없으면 멈추자
}//outer-for

console.log(array);