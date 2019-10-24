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
  preFilterProfile: Profile[];
  profiles: Profile[];

  constructor(private profileService: ProfileService) { }

  ngOnInit() {
    console.log("--- Inside ProfileListComponent");
    this.profileService.getSelection().subscribe(data => {
      this.profiles = data;
    });
  }

  filter(value: number){
    this.profiles = this.preFilterProfile.filter(function(number) {
      return number.age > value;
    });
    
  }

}
