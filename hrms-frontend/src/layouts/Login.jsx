import React from 'react'
import { NavLink } from 'react-router-dom'
import { Dropdown, Menu, Image } from 'semantic-ui-react'

export default function Login({ logOut }) {
    return (
        <div>
            <Menu.Item>
                <Image avatar spaced="right" src="https://avatars.githubusercontent.com/u/75336900?v=4"></Image>
                <Dropdown pointing="top left" text="Berkcan Gümüşışık" style={{color:"black"}}>
                    <Dropdown.Menu>
                        <Dropdown.Item as={NavLink} to={"/profile/24"} text="Bilgilerim" icon="info" />
                        <Dropdown.Item onClick={logOut} text="Çıkış Yap" icon="sign-out" />
                    </Dropdown.Menu>
                </Dropdown>
            </Menu.Item>
        </div>

    )
}