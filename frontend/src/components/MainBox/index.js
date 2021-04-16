import "./index.css"
import React from "react"
import TaskMap from "./TaskMap";
import TaskList from "./TaskList";
import Dashboard from "./Dashboard"


export default function MainBox(props) {

    const featureControl = () => {
        if (props.feature === 1) {
            return (
                <Dashboard></Dashboard>)
        }
        else if (props.feature === 2) {
            return (
                <TaskMap></TaskMap>
            )
        }
        else if (props.feature === 3) {
            return (
                <TaskList></TaskList>
            )
        }
    }

    return (
        <>
            {featureControl()}
        </>
    )
}

