import { Component, OnInit } from '@angular/core';
import { Profile } from '../profile';
import { ActivatedRoute, Router } from '@angular/router';
import { ProfileService } from '../profile.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit{

  profile : Profile;

  constructor(private route: ActivatedRoute, private router: Router, private profileService: ProfileService) {
  }

  ngOnInit(): void {
    this.profileService.getMyProfile().subscribe(result => this.profile = result);
  }
 
  delete() {
    this.profileService.delete().subscribe(result => this.gotoHome());
  }

  onSubmit(){
    this.profileService.edit(this.profile).subscribe(result => this.gotoHome);
  }

  gotoHome() {
    this.router.navigate(['/home']);
  }

}
