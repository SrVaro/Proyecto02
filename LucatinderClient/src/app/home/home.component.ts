import { Component, OnInit } from '@angular/core';
import {Profile} from '../profile';
import {ProfileService} from '../profile.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  value = 0;
  profiles: Profile[];
  aux: Profile[];

  constructor(private profileService: ProfileService) { }

  ngOnInit() {
    console.log("--- Inside ProfileListComponent");
    this.profileService.getSelection().subscribe(data => {
      this.profiles = data;
      this.aux = data;
    });
  }

  filter(value: number){
    this.profiles = this.aux.filter(function(number) {
      return number.age > value;
    });
    
  }

}
