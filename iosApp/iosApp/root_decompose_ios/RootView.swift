//
//  RootView.swift
//  iosApp
//
//  Created by Элдияр Укенов on 12.06.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct RootView: UIViewControllerRepresentable {
    let root: RootComponent

    func makeUIViewController(context: Context) -> UIViewController {
        return RootViewControllerKt.rootViewController(root: root)
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {
    }
}
