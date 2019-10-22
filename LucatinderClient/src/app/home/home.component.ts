import { Component, OnInit } from '@angular/core';
import {Profile} from '../profile';
import {ProfileService} from '../profile.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {


  profiles: Profile[];

  constructor(private profileService: ProfileService) { }

  ngOnInit() {
    console.log("--- Inside ProfileListComponent");
    this.profileService.findAll().subscribe(data => {
      this.profiles = data;
    });
  }

  like(profile: Profile){
    this.profiles = this.profiles.filter(p => p !== profile);
  }

  dislike(profile: Profile){
    this.profiles = this.profiles.filter(p => p !== profile);
  }


}
