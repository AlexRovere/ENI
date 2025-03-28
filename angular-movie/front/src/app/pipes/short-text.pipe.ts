import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'shortText'
})
export class ShortTextPipe implements PipeTransform {

  transform(value: string, number: number = 50): unknown {
    let newValue = value
    if(value.length >= number){
      newValue = value.slice(0, number) + "..."
    }
    return newValue;
  }

}
