import { Component, OnInit } from '@angular/core';
import { Profile } from '../profile';
import { ProfileService } from '../profile.service';

@Component({
  selector: 'app-matches',
  templateUrl: './matches.component.html',
  styleUrls: ['./matches.component.css']
})
export class MatchesComponent implements OnInit {

  profiles: Profile[];

  constructor(private profileService: ProfileService) { }

  ngOnInit() {
    console.log("--- Inside ProfileListComponent");
    this.profileService.getMatches().subscribe(data => {
      this.profiles = data;
    });
  }

}
