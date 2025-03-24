import {Component} from '@angular/core';

@Component({
  selector: 'app-image-toggle',
  imports: [],
  templateUrl: './image-toggle.component.html',
  styleUrl: './image-toggle.component.scss'
})
export class ImageToggleComponent {
  imageVisible: boolean = false
  clickCount: number = 0
  imgPath: string = "poing.jpg"

  toggleImg() {
    this.imageVisible= !this.imageVisible
    this.clickCount++
  }
}
