import {Component, OnInit} from '@angular/core';
import {RouterOutlet} from '@angular/router';
import {initFlowbite} from 'flowbite';
import {HeaderComponent} from './shared/header/header.component';
import {FooterComponent} from './shared/footer/footer.component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, HeaderComponent, FooterComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent implements OnInit{
  title = 'FirstDemo';
  ngOnInit(): void {
    initFlowbite();
  }
}
