import {Button, Label, TextInput, Toast} from "flowbite-react";
import {FormEvent, useCallback, useState} from "react";
import {useLocalStorage} from "@uidotdev/usehooks";
import {callBackendNoToken} from "./ptmplace.tsx";
import {Token} from "./user.tsx";
import {HiX} from "react-icons/hi";
import {useNavigate} from "react-router";

export function SignIn() {
    const [_, setAccessToken] = useLocalStorage('access_token', {} as Token)
    const [isShowToast, setIsShowToast] = useState(false)
    const navigate = useNavigate()

    return (
        <>
            {
                isShowToast ?
                    <Toast>
                        <div className="inline-flex h-8 w-8 shrink-0 items-center justify-center rounded-lg bg-red-100 text-red-500 dark:bg-red-800 dark:text-red-200">
                            <HiX className="h-5 w-5" />
                        </div>
                        <div className="ml-3 text-sm font-normal">Ошибка авторизации</div>
                        <Toast.Toggle />
                    </Toast> : null
            }
            <div className="flex min-h-screen min-w-screen items-center justify-center flex-col">
                <form className="flex w-7xl flex-col gap-4"
                      onSubmit={useCallback((event: FormEvent<HTMLFormElement>) => {
                          event.preventDefault()
                          const elements = event.currentTarget.elements as any
                          const email = elements.email.value
                          const password = elements.password.value

                          callBackendNoToken('authentication/authenticate', {
                              method: 'POST',
                              body: JSON.stringify({
                                  email, password
                              }),
                              headers: {
                                  'Content-Type': 'application/json'
                              }
                          })
                              .then(res => {
                                  if (!res.ok) {
                                      setIsShowToast(true)
                                  }

                                  return res.json()
                              })
                              .then(res => {
                                  setAccessToken({token: res.access_token})
                                  navigate('/')
                              })
                      }, [setAccessToken, setIsShowToast, navigate])}>
                    <div>
                        <div className="mb-2 block">
                            <Label htmlFor="email" value="Ваш E-mail"/>
                        </div>
                        <TextInput id="email" name="email" type="email" placeholder="me@example.com" required/>
                    </div>
                    <div>
                        <div className="mb-2 block">
                            <Label htmlFor="password" value="Ваш пароль"/>
                        </div>
                        <TextInput id="password" name="password" type="password" required/>
                    </div>
                    <Button type="submit">Войти</Button>
                </form>
            </div>
        </>
    )
}