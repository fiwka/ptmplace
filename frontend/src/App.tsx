import AppNavbar from "./AppNavbar.tsx";
import {useEffect, useState} from "react";
import {Token, User} from "./user.tsx";
import {callBackend} from "./ptmplace.tsx";
import {useLocalStorage} from "@uidotdev/usehooks";

function App() {
    const [user, setUser] = useState({} as User)
    const [isUserSet, setIsUserSet] = useState(false)
    const [accessToken, setAccessToken] = useLocalStorage('access_token', {} as Token)

    useEffect(() => {
        if (!isUserSet) {
            callBackend('user/me', accessToken.token)
                .then(res => {
                    if (!res.ok) {
                        setAccessToken({} as Token)
                        return null
                    }

                    return res.json()
                })
                .then(setUser)

            setIsUserSet(true)
        }
    })

    return (
        <>
            <AppNavbar/>
            <h1>{user.email}</h1>
        </>
    )
}

export default App
