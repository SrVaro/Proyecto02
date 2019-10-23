import { Component, OnInit } from '@angular/core';
import { Profile } from '../profile';
import { ProfileService } from '../profile.service';

@Component({
  selector: 'app-discards',
  templateUrl: './discards.component.html',
  styleUrls: ['./discards.component.css']
})
export class DiscardsComponent implements OnInit {

  profiles: Profile[];

  constructor(private profileService: ProfileService) { }

  ngOnInit() {
    console.log("--- Inside ProfileListComponent");
    this.profileService.getDiscards().subscribe(data => {
      this.profiles = data;
    });
  }
}
